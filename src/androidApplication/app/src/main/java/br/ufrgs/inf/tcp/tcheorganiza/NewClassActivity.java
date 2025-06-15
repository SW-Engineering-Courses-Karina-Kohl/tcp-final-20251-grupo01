package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewClassBinding;
import br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas.NewCourseFragment;

public class NewClassActivity extends AppCompatActivity {

    private ActivityNewClassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpButtonContinuar();

    }
    private void setUpButtonContinuar(){
        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(NewClassActivity.this, NewTaskActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
    private void setUpButtonAdicionar(){
        binding.buttonAddDisciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTextFields();
            }
        });
    }
    //Clearing fields for next Disciplina to be add
    private void clearTextFields(){
    }

}