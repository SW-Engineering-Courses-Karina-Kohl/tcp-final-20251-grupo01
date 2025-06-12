package br.ufrgs.inf.tcp.tcheorganiza.ui.professor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddProfessorBinding;
import br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas.AddClassActivity;

public class AddProfessorActivity extends AppCompatActivity {

    private ActivityAddProfessorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonConcluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newProfessorActivityIntent = new Intent(AddProfessorActivity.this, AddClassActivity.class);
                startActivity(newProfessorActivityIntent);
            }
        });
    }
}
