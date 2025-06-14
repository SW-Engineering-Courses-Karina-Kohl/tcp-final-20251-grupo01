package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.os.Bundle;
import android.app.TimePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class CourseHourFragment extends Fragment {

    private EditText editStartTime, editEndTime;
    private FloatingActionButton deleteButton;

    public CourseHourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_course_hour, container, false);

        editStartTime = root.findViewById(R.id.editStartTime);
        editEndTime = root.findViewById(R.id.editEndTime);
        deleteButton = root.findViewById(R.id.buttonDeleteHour);

        editStartTime.setOnClickListener(v -> showTimePicker(editStartTime));
        editEndTime.setOnClickListener(v -> showTimePicker(editEndTime));
        deleteButton.setOnClickListener(v -> deleteThisHour());

        return root;
    }

    private void showTimePicker(final EditText editText) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                (TimePicker view, int hourOfDay, int minute1) -> {
                    String time = String.format("%02d:%02d", hourOfDay, minute1);
                    editText.setText(time);
                }, hour, minute, true);

        timePickerDialog.show();
    }

    private void deleteThisHour() {
        requireActivity().runOnUiThread(() -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .remove(this)
                    .commit();
        });
    }
}