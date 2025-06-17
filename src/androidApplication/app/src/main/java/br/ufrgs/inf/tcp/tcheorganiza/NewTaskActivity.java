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
import br.ufrgs.inf.tcp.tcheorganiza.ui.tasks.NewTaskFragment;

public class NewTaskActivity extends AppCompatActivity {

    private ActivityNewTaskBinding binding;
    private NewTaskFragment newTaskFragment;

    //Creating activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setButtonContinuar();
        setButtonAdicionar();

        newTaskFragment = (NewTaskFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view_new_task);


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
                boolean saved = newTaskFragment.saveNewTask();
            }
        });
    }

}