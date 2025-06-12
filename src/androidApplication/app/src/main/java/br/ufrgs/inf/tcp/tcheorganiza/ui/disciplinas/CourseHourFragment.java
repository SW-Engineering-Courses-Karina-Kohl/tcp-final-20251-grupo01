package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.os.Bundle;

import android.app.TimePickerDialog;
import android.widget.EditText;
import android.widget.TimePicker;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseHourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseHourFragment extends Fragment {

    private EditText editStartTime, editEndTime;

    public CourseHourFragment() {
        // Required empty public constructor
    }

    public static CourseHourFragment newInstance(String param1, String param2) {
        CourseHourFragment fragment = new CourseHourFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_course_hour, container, false);

        editStartTime = root.findViewById(R.id.editStartTime);
        editEndTime = root.findViewById(R.id.editEndTime);

        editStartTime.setOnClickListener(v -> showTimePicker(editStartTime));
        editEndTime.setOnClickListener(v -> showTimePicker(editEndTime));

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
}