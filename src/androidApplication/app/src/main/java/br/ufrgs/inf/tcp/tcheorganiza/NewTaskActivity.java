package br.ufrgs.inf.tcp.tcheorganiza;



import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import org.threeten.bp.LocalDate;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;

public class NewTaskActivity extends AppCompatActivity {

    private ActivityNewTaskBinding binding;
    private AutoCompleteTextView courseAutoComplete;
    private Course selectCourseInstance;

    //Creating activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupDropdownTipo();
        setButtonContinuar();
        setButtonAdicionar();
        setupDropdownDisciplinas();
        binding.textInputData.setOnClickListener(v -> showDatePicker());

    }

    //Dropdown "Tipo"
    private void setupDropdownTipo(){
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_tipo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.dropdown_options_tipo_atividade,
                android.R.layout.simple_dropdown_item_1line
        );
        dropdown.setAdapter(adapter);

    }

    private void setupDropdownDisciplinas(){
        courseAutoComplete = findViewById(R.id.dropdown_menu_disciplina);
        ArrayAdapter<Course> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                TcheOrganizaPersistence.getInstance().getDisciplinasList()
        );
        courseAutoComplete.setAdapter(adapter);
        courseAutoComplete.setOnItemClickListener((parent, view, position, id) -> {
            Course selectedCourse = (Course) parent.getItemAtPosition(position);
            selectCourseInstance = selectedCourse;
        });
    }

    //Setting up buttons
    private void setButtonContinuar(){
        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(NewTaskActivity.this, PreferenceRuActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
    private void setButtonAdicionar(){
        binding.buttonAddTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewTask();
            }
        });
    }

    //Setting up Date picker
    private int yearSelected;
    private int monthSelected;
    private int daySelected;
    private String dateSelected;

    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(NewTaskActivity.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    yearSelected = selectedYear;
                    monthSelected = selectedMonth;
                    daySelected = selectedDay;
                    dateSelected = String.format("%04d-%02d-%02d", yearSelected, monthSelected + 1, daySelected);
                    binding.textInputData.setText(String.format("%02d/%02d/%04d", daySelected, monthSelected + 1, yearSelected));
                }, year, month, day);
        datePickerDialog.show();
    }

    //GETTERS
    public String getTaskName(){
        return binding.textInputNomeAtividade.getText().toString().trim();
    }
    public String getTaskType(){
       return binding.dropdownMenuTipo.getText().toString().trim();
    }
    public String getTaskDescription(){
        return binding.textInputDescricao.getText().toString();
    }
    public String getTaskContent(){
        return binding.textInputConteudo.getText().toString();
    }
    public Course getCourseSelected(){
        return selectCourseInstance;
    }
    public String getDateSelected(){
        return dateSelected;
    }
    public String getBuilding(){
        return binding.textInputPredio.getText().toString().trim();
    }
    public String getRoom(){
        return binding.textInputSala.getText().toString().trim();
    }

    //Saving date from fields in the persistence class
    public void saveNewTask() {
        String taskName = getTaskName();
        String taskDescription = getTaskDescription();
        String taskContent = getTaskContent();
        String taskDate = getDateSelected();
        String taskType = getTaskType();
        String taskRoom = getRoom();
        String taskBuilding = getBuilding();
        if(taskName.isEmpty()
                || taskDescription.isEmpty()
                || taskDate.isEmpty()
                || taskType.isEmpty()
                || taskRoom.isEmpty()
                || taskBuilding.isEmpty()
                || selectCourseInstance == null) {
            new AlertDialog.Builder(NewTaskActivity.this)
                    .setMessage("Preencha todos os campos obrigatórios")
                    .setPositiveButton("OK", (dialog, which) -> {})
                    .show();
        } else {
            TcheOrganizaPersistence.getInstance()
                    .addTask(selectCourseInstance,
                            taskName,
                            taskDescription,
                            LocalDate.parse(taskDate),
                            taskType,
                            taskContent,
                            Integer.parseInt(taskRoom),
                            Integer.parseInt(taskBuilding));

            new AlertDialog.Builder(NewTaskActivity.this)
                    .setMessage("Atividade adicionada com sucesso!")
                    .setPositiveButton("OK", (dialog, which) -> {
                        clearTextFields();})
                    .show();
        }
    }

    //Reseting fields
    private void resetTextInputNomeAtividade(){
        binding.textInputNomeAtividade.setText("");
        binding.textInputNomeAtividade.clearFocus();
    }
    private void resetTextInputData(){
        binding.textInputData.setText("");
        binding.textInputData.clearFocus();
    }
    private void resetDropdownTipo(){
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_tipo);
        dropdown.setText("",false);
        binding.textInputDropdownTipo.clearFocus();
    }
    private void resetDropdownMenuDisciplina(){
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_disciplina);
        dropdown.setText("",false);
//        binding.dropdownMenuDisciplina.setText("",false);
        binding.dropdownMenuDisciplina.clearFocus();
    }
    private void resetTextInputDescricao(){
        binding.textInputDescricao.setText("");
        binding.textInputDescricao.clearFocus();
    }
    private void resetTextInputConteudo(){
        binding.textInputConteudo.setText("");
        binding.textInputConteudo.clearFocus();
    }
    private void resetTextInputPredio(){
        binding.textInputPredio.setText("");
        binding.textInputPredio.clearFocus();
    }
    private void resetTextInputSala(){
        binding.textInputSala.setText("");
        binding.textInputSala.clearFocus();
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