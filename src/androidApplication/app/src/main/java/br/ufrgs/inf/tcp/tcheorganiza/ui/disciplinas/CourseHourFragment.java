package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class CourseHourFragment extends Fragment {

    private Spinner spinnerWeekday;
    private TextInputEditText editStartTime, editEndTime, editBuilding, editRoom;
    private FloatingActionButton deleteButton;

    public CourseHourFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_course_hour, container, false);

        spinnerWeekday = root.findViewById(R.id.spinnerWeekday);
        editStartTime = root.findViewById(R.id.editStartTime);
        editEndTime = root.findViewById(R.id.editEndTime);
        editBuilding = root.findViewById(R.id.textInputPredio);
        editRoom = root.findViewById(R.id.textInputSala);
//        editLocation = root.findViewById(R.id.editLocation);
        deleteButton = root.findViewById(R.id.buttonDeleteHour);

        editStartTime.setOnClickListener(v -> showTimePicker(editStartTime));
        editEndTime.setOnClickListener(v -> showTimePicker(editEndTime));
        deleteButton.setOnClickListener(v -> deleteThisHour());

        return root;
    }

    private void showTimePicker(final TextInputEditText editText) {
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

    public String getWeekDay() {
        return spinnerWeekday.getSelectedItem() != null ? spinnerWeekday.getSelectedItem().toString() : "";
    }

    public String getStartTime() {
        return editStartTime.getText() != null ? editStartTime.getText().toString() : "";
    }

    public String getEndTime() {
        return editEndTime.getText() != null ? editEndTime.getText().toString() : "";
    }

//    public String getLocation() {
//        return editLocation.getText() != null ? editLocation.getText().toString() : "";
//    }
    public String getBuilding() {
        return editBuilding.getText() != null ? editBuilding.getText().toString() : "";
    }
    public String getRoom() {
        return editRoom.getText() != null ? editRoom.getText().toString() : "";
    }
}