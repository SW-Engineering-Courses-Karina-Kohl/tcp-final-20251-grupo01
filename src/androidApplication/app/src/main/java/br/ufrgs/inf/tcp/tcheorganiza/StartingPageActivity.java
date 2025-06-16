package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jakewharton.threetenabp.AndroidThreeTen;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityStartingPageBinding;

public class StartingPageActivity extends AppCompatActivity {

    private ActivityStartingPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        binding = ActivityStartingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonAddDisciplinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(StartingPageActivity.this, NewProfessorActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
}