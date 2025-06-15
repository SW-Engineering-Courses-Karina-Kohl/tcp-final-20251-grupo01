package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class NewCourseFragment extends Fragment {

    private ViewGroup courseHourList;
    private EditText courseNameEditText, courseEndDateEditText;

    // TODO: Change to proper data type
    private EditText professorEditText;

    public NewCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root  = inflater.inflate(R.layout.fragment_new_course, container, false);

        View newCourseHourButton = root.findViewById(R.id.button_add_hour);

        courseHourList = root.findViewById(R.id.linear_layout_course_hour_list);
        courseNameEditText = root.findViewById(R.id.text_input_course_name);
        courseEndDateEditText = root.findViewById(R.id.text_input_course_end_date);
        professorEditText = root.findViewById(R.id.text_input_professor);

        courseEndDateEditText.setOnClickListener(v -> showDatePicker());
        newCourseHourButton.setOnClickListener(v -> addCourseHour());

        return root;
    }

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear);
                    courseEndDateEditText.setText(date);
                }, year, month, day);

        datePickerDialog.show();
    }

    public void addCourseHour() {
        // Cria um novo container para o fragmento
        FrameLayout container = new FrameLayout(requireContext());
        int containerId = View.generateViewId();  // Gera ID único
        container.setId(containerId);
        courseHourList.addView(container);

        // Adiciona o fragmento
        getChildFragmentManager()
                .beginTransaction()
                .add(containerId, new CourseHourFragment())
                .commit();
    }

    // TODO: Conectar com o banco de dados
    public boolean saveCourse() {
        String courseName = courseNameEditText.getText().toString().trim();
        String endDate = courseEndDateEditText.getText().toString().trim();
        String professorName = professorEditText.getText().toString().trim();

        List<String> classDays = new ArrayList<>();
        List<String> classStartHours = new ArrayList<>();
        List<String> classEndHours = new ArrayList<>();
        List<String> classLocations = new ArrayList<>();
        int hoursCount = 0;

        List<Fragment> fragments = getChildFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            if (fragment instanceof CourseHourFragment) {
                String day = ((CourseHourFragment) fragment).getDay();
                String start = ((CourseHourFragment) fragment).getStartTime();
                String end = ((CourseHourFragment) fragment).getEndTime();
                String location = ((CourseHourFragment) fragment).getLocation();

                // Só adiciona se tiver todos os campos preenchidos
                if (!day.isEmpty() && !start.isEmpty() && !end.isEmpty()) {
                    classDays.add(day);
                    classStartHours.add(start);
                    classEndHours.add(end);
                    classLocations.add(location);
                    hoursCount++;
                }
            }
        }

        if (courseName.isEmpty() || endDate.isEmpty() || professorName.isEmpty()) {
            Toast.makeText(getContext(), "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (hoursCount == 0) {
            Toast.makeText(getContext(), "Adicione pelo menos um horário de aula válido", Toast.LENGTH_SHORT).show();
            return false;
        }

        Toast.makeText(getContext(), "Curso salvo com sucesso", Toast.LENGTH_SHORT).show();
        return true;
    }
}