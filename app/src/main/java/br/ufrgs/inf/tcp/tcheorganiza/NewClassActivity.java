package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewClassBinding;
import br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas.NewCourseFragment;

public class NewClassActivity extends AppCompatActivity {

    private ActivityNewClassBinding binding;
    private NewCourseFragment newCourseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpButtonContinuar();
        setUpButtonAdicionar();
        newCourseFragment = (NewCourseFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view_new_course);


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
                boolean save = newCourseFragment.saveCourse();
            }
        });
    }



}