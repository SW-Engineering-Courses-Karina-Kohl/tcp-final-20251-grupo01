package br.ufrgs.inf.tcp.tcheorganiza.ui.tasks;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.jakewharton.threetenabp.AndroidThreeTen;
import org.threeten.bp.LocalDate;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;

public class NewTaskFragment extends Fragment {

    private EditText taskNameEditText, taskDateEditText, taskDescriptionEditText, taskContentEditText, taskBuildingEditText, taskRoomEditText;
    private AutoCompleteTextView taskTypeAutoComplete, taskCourseAutoComplete;
    private Course selectCourseInstance;

    public NewTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_new_task, container, false);

        taskNameEditText = root.findViewById(R.id.text_input_nome_atividade);

        taskDateEditText = root.findViewById(R.id.text_input_data);
        taskDateEditText.setOnClickListener(v -> showDatePicker());

        taskTypeAutoComplete = root.findViewById(R.id.dropdown_menu_tipo);

        taskCourseAutoComplete = root.findViewById(R.id.dropdown_menu_disciplina);

        taskBuildingEditText = root.findViewById(R.id.text_input_predio);

        taskRoomEditText = root.findViewById(R.id.text_input_sala);

        taskDescriptionEditText = root.findViewById(R.id.text_input_descricao);

        taskContentEditText = root.findViewById(R.id.text_input_conteudo);
        taskContentEditText.setVisibility(GONE);

        setupDropdownTipo(root);
        setupDropdownDisciplinas(root);

        AndroidThreeTen.init(getContext());

        return root;
    }

    //Dropdown "Tipo"
    private void setupDropdownTipo(View root) {
        AutoCompleteTextView dropdown = root.findViewById(R.id.dropdown_menu_tipo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.dropdown_options_tipo_atividade,
                android.R.layout.simple_dropdown_item_1line
        );
        dropdown.setAdapter(adapter);

        dropdown.setOnItemClickListener((parent, view, position, id) -> {
            String selectedType = (String) parent.getItemAtPosition(position);
            if(selectedType.equals("Prova")){
                taskContentEditText.setVisibility(VISIBLE);
            } else {
                taskContentEditText.setVisibility(GONE);
            }
        });
    }

    private void setupDropdownDisciplinas(View root) {
        taskCourseAutoComplete = root.findViewById(R.id.dropdown_menu_disciplina);
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_dropdown_item_1line,
                TcheOrganizaPersistence.getInstance().getDisciplinasList()
        );
        taskCourseAutoComplete.setAdapter(adapter);
        taskCourseAutoComplete.setOnItemClickListener((parent, view, position, id) -> {
            Course selectedCourse = (Course) parent.getItemAtPosition(position);
            selectCourseInstance = selectedCourse;
        });
    }

    //Setting up Date picker
    private String dateSelected;

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    dateSelected = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDay);
                    taskDateEditText.setText(String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear));
                }, year, month, day);
        datePickerDialog.show();
    }

    //Getters
    public String getTaskName() {
        if (taskNameEditText == null || taskNameEditText.getText() == null) return "";
        return taskNameEditText.getText().toString().trim();
    }

    public String getTaskDate() {
        if (taskDateEditText == null || taskDateEditText.getText() == null) return "";
        return taskDateEditText.getText().toString().trim();
    }

    public String getTaskType() {
        if (taskTypeAutoComplete == null || taskTypeAutoComplete.getText() == null) return "";
        return taskTypeAutoComplete.getText().toString().trim();
    }

    public String getTaskCourse() {
        if (taskCourseAutoComplete == null || taskCourseAutoComplete.getText() == null) return "";
        return taskCourseAutoComplete.getText().toString().trim();
    }

    public String getTaskBuilding() {
        if (taskBuildingEditText == null || taskBuildingEditText.getText() == null) return "";
        return taskBuildingEditText.getText().toString().trim();
    }

    public String getTaskRoom() {
        if (taskRoomEditText == null || taskRoomEditText.getText() == null) return "";
        return taskRoomEditText.getText().toString().trim();
    }

    public String getTaskDescription() {
        if (taskDescriptionEditText == null || taskDescriptionEditText.getText() == null) return "";
        return taskDescriptionEditText.getText().toString().trim();
    }

    public String getTaskContent() {
        if (taskContentEditText == null || taskContentEditText.getText() == null) return "";
        return taskContentEditText.getText().toString().trim();
    }


    //Saving date from fields in the persistence class
    public boolean saveNewTask() {
        String taskName = getTaskName();
        String taskDescription = getTaskDescription();
        String taskContent = getTaskContent();
        String taskDate = getTaskDate();
        String taskType = getTaskType();
        String taskRoom = getTaskRoom();
        String taskBuilding = getTaskBuilding();

        if (taskType.isEmpty()){
                new AlertDialog.Builder(getContext())
                        .setMessage("Por favor, preencha o Tipo de atividade")
                        .setPositiveButton("OK", (dialog, which) -> {
                        })
                        .show();
                return false;
        }
        //Local é opicional para Trabalho
        if ((taskType.equals("Prova") || taskType.equals("Laboratório")) && (taskBuilding.isEmpty() || taskRoom.isEmpty())) {
            new AlertDialog.Builder(getContext())
                    .setMessage("Por favor, preencha o Prédio e Sala")
                    .setPositiveButton("OK", (dialog, which) -> {
                    })
                    .show();
            return false;
        }

        if (taskName.isEmpty()
                || taskDescription.isEmpty()
                || taskDate.isEmpty()
                || selectCourseInstance == null) {
            new AlertDialog.Builder(getContext())
                    .setMessage("Preencha todos os campos obrigatórios")
                    .setPositiveButton("OK", (dialog, which) -> {
                    })
                    .show();
            return false;
        }
        if(taskType.equals("Trabalho") || taskType.equals("Tarefa")){
            taskBuilding = "0";
            taskRoom = "0";
        }

        try {
            TcheOrganizaPersistence.getInstance()
                    .addTask(selectCourseInstance,
                            taskName,
                            taskDescription,
                            LocalDate.parse(dateSelected),
                            taskType,
                            taskContent,
                            Integer.parseInt(taskRoom),
                            Integer.parseInt(taskBuilding));

            new AlertDialog.Builder(getContext())
                    .setMessage("Atividade adicionada com sucesso!")
                    .setPositiveButton("OK", (dialog, which) -> {
                        clearTextFields();
                    })
                    .show();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            new AlertDialog.Builder(getContext())
                    .setMessage("Erro ao salvar a atividade: " + e.getMessage())
                    .setPositiveButton("OK", null)
                    .show();
            return false;
        }


    }

    //Reseting fields
    private void resetTextInputNomeAtividade(){
        taskNameEditText.setText("");
        taskNameEditText.clearFocus();
    }
    private void resetTextInputData(){
        taskDateEditText.setText("");
        taskDateEditText.clearFocus();
    }
    private void resetDropdownTipo(){
        taskTypeAutoComplete.setText("",false);
        taskTypeAutoComplete.clearFocus();
    }
    private void resetDropdownMenuDisciplina(){
        taskCourseAutoComplete.setText("",false);
        taskCourseAutoComplete.clearFocus();
    }
    private void resetTextInputDescricao(){
        taskDescriptionEditText.setText("");
        taskDescriptionEditText.clearFocus();
    }
    private void resetTextInputConteudo(){
        taskContentEditText.setText("");
        taskContentEditText.clearFocus();
    }
    private void resetTextInputPredio(){
        taskBuildingEditText.setText("");
        taskBuildingEditText.clearFocus();
    }
    private void resetTextInputSala(){
        taskRoomEditText.setText("");
        taskRoomEditText.clearFocus();
    }

    //Clearing fields for next Task to be add
    private void clearTextFields(){
        resetTextInputNomeAtividade();
        resetTextInputData();
        resetDropdownTipo();
        resetDropdownMenuDisciplina();
        resetTextInputDescricao();
        resetTextInputConteudo();
        resetTextInputPredio();
        resetTextInputSala();
    }


}