package br.ufrgs.inf.tcp.tcheorganiza;



import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Teacher;
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
    private void resetDropdownTipo(){
        courseAutoComplete = binding.dropdownMenuDisciplina;
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_tipo);
        dropdown.setText("",false);
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
                //ADICIONAR FUNÇÃO AQUI PARA PEGAR AS INFORMAÇÕES
                saveNewTask();
                new AlertDialog.Builder(NewTaskActivity.this)
                        .setMessage("Atividade adicionada com sucesso!")
                        .setPositiveButton("OK", (dialog, which) -> {
                            clearTextFields();})
                        .show();
            }
        });
    }
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
                    dateSelected = String.format("%02d/%02d/%04d", daySelected, monthSelected + 1, yearSelected);
                    binding.textInputData.setText(dateSelected);
                }, year, month, day);
        datePickerDialog.show();


    }
    private String getTaskName(){
        return binding.textInputNomeAtividade.getText().toString().trim();
    }

    private String getTaskType(){
       return binding.dropdownMenuTipo.getText().toString().trim();
    }
    private String getTaskDescription(){
        return binding.textInputDescricao.getText().toString();
    }

    private void saveNewTask() {
        getTaskName();
        getTaskType();
        getTaskDescription();
    }

    //Clearing fields for next Task to be add
    private void clearTextFields(){
        binding.textInputNomeAtividade.setText("");
        binding.textInputNomeAtividade.clearFocus();

        binding.textInputData.setText("");
        binding.textInputData.clearFocus();

        resetDropdownTipo();
        binding.textInputDropdownTipo.clearFocus();
        
        binding.dropdownMenuDisciplina.setText("");
        binding.dropdownMenuDisciplina.clearFocus();


        binding.textInputDescricao.setText("");
        binding.textInputDescricao.clearFocus();
    }
}