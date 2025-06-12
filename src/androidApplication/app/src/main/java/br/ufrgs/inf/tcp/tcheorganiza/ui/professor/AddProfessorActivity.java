package br.ufrgs.inf.tcp.tcheorganiza.ui.professor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        binding.buttonAddProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //COLOCAR FUNÇÃO AQUI PARA PEGAR DADOS
                Toast.makeText(AddProfessorActivity.this,"Professor adicionado!",Toast.LENGTH_LONG).show();
                clearTextFields();
            }
        });
    }

    private void clearTextFields(){
        binding.textInputProfessorName.setText("");
        binding.textInputProfessorName.clearFocus();


        binding.textInputSala.setText("");
        binding.textInputSala.clearFocus();


        binding.textInputProfessorEmail.setText("");
        binding.textInputProfessorEmail.clearFocus();
    }
}
