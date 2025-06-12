package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddClassBinding;
import br.ufrgs.inf.tcp.tcheorganiza.ui.professor.AddProfessorActivity;

public class AddClassActivity extends AppCompatActivity {

    private ActivityAddClassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonAddProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newAddProfIntent = new Intent(AddClassActivity.this, AddProfessorActivity.class);
                startActivity(newAddProfIntent);
            }
        });

    }
}