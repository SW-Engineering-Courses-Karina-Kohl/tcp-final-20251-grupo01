package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityStartingPageBinding;

public class StartingPageActivity extends AppCompatActivity {

    private ActivityStartingPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonAddDisciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(StartingPageActivity.this, NewClassActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
}