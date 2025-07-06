package br.ufrgs.inf.tcp.tcheorganiza.ui.tasks;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import br.ufrgs.inf.tcp.tcheorganiza.MainActivity;
import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddTasksBinding;

public class AddTasksActivity extends AppCompatActivity {

    private ActivityAddTasksBinding binding;
    private NewTaskFragment newTaskFragment;

    //Creating activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddTasksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setButtonConcluido();
        setButtonAdicionar();

        newTaskFragment = (NewTaskFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view_new_task);

    }

    //Setting up buttons
    private void setButtonConcluido(){
        binding.buttonConcluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(AddTasksActivity.this, MainActivity.class);
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