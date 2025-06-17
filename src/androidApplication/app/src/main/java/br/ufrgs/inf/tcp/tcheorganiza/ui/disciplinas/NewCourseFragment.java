package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.NewProfessorActivity;
import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Schedule;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Teacher;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;

public class NewCourseFragment extends Fragment {

    private ViewGroup courseHourList;
    private EditText courseNameEditText, courseEndDateEditText;
    private AutoCompleteTextView professorAutoComplete;
    private Teacher selectedTeacherInstance;

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
        professorAutoComplete = root.findViewById(R.id.dropdown_menu_professor);
        courseEndDateEditText.setOnClickListener(v -> showDatePicker());
        newCourseHourButton.setOnClickListener(v -> addCourseHour());
        setupDropdownProfessor(root);
        AndroidThreeTen.init(getContext());

        return root;
    }


    private void setupDropdownProfessor(View root){
        AutoCompleteTextView dropdown = root.findViewById(R.id.dropdown_menu_professor);
        ArrayAdapter<Teacher> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_dropdown_item_1line,
                TcheOrganizaPersistence.getInstance().getTeachersList()
        );
        dropdown.setAdapter(adapter);
        professorAutoComplete.setOnItemClickListener((parent, view, position, id) -> {
            Teacher selectedTeacher = (Teacher) parent.getItemAtPosition(position);
            selectedTeacherInstance = selectedTeacher;
        });
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


        List<String> classDays = new ArrayList<>();
        List<String> classStartHours = new ArrayList<>();
        List<String> classEndHours = new ArrayList<>();
        List<String> classLocations = new ArrayList<>();
        List<Schedule> scheduleList = new ArrayList<>();
        int hoursCount = 0;

        List<Fragment> fragments = getChildFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            if (fragment instanceof CourseHourFragment) {
                String day = ((CourseHourFragment) fragment).getWeekDay();
                String start = ((CourseHourFragment) fragment).getStartTime();
                String end = ((CourseHourFragment) fragment).getEndTime();
                String building = ((CourseHourFragment) fragment).getBuilding();
                String room = ((CourseHourFragment) fragment).getRoom();

                // Só adiciona se tiver todos os campos preenchidos
                if (!day.isEmpty() && !start.isEmpty() && !end.isEmpty()) {
                    scheduleList.add(new Schedule(day,new Office(Integer.parseInt(room),Integer.parseInt(building)), LocalTime.parse(start),LocalTime.parse(end)));
//                    classDays.add(day);
//                    classStartHours.add(start);
//                    classEndHours.add(end);
//                    classLocations.add(location);
                    hoursCount++;
                }
            }
        }

        if (courseName.isEmpty() || endDate.isEmpty() || selectedTeacherInstance == null) {
            new AlertDialog.Builder(getContext())
                    .setMessage("Preencha todos os campos obrigatórios")
                    .setPositiveButton("OK", (dialog, which) -> {})
                    .show();
//            Toast.makeText(getContext(), "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (hoursCount == 0) {
            new AlertDialog.Builder(getContext())
                    .setMessage("Adicione pelo menos um horário de aula válido")
                    .setPositiveButton("OK", (dialog, which) -> {})
                    .show();
//            Toast.makeText(getContext(), "Adicione pelo menos um horário de aula válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        new AlertDialog.Builder(getContext())
                .setMessage("Disciplina adicionada com sucesso!")
                .setPositiveButton("OK", (dialog, which) -> {})
                .show();
        TcheOrganizaPersistence.getInstance().addDisciplinaToList(courseName,selectedTeacherInstance,scheduleList);
//        Toast.makeText(getContext(), "Curso salvo com sucesso", Toast.LENGTH_SHORT).show();
        return true;
    }
}