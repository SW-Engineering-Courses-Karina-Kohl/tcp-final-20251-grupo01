package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityMainBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;

public class NewTaskActivity extends AppCompatActivity {

    private ActivityNewTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(NewTaskActivity.this, PreferenceRuActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
}