package br.ufrgs.inf.tcp.tcheorganiza.ui.professor;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddProfessorBinding;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas.AddClassActivity;

public class AddProfessorActivity extends AppCompatActivity {

    private ActivityAddProfessorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setButtonAddProf();
        setButtonConcluido();

    }

    private void setButtonAddProf(){
        binding.buttonAddProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //COLOCAR FUNÇÃO AQUI PARA PEGAR DADOS
                saveData();
                new AlertDialog.Builder(AddProfessorActivity.this)
                        .setMessage("Professor(a) adicionado(a) com sucesso!")
                        .setPositiveButton("OK", (dialog, which) -> {
                            clearTextFields();})
                        .show();
            }
        });
    }

    private void setButtonConcluido(){
        binding.buttonConcluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newProfessorActivityIntent = new Intent(AddProfessorActivity.this, AddClassActivity.class);
                startActivity(newProfessorActivityIntent);
            }
        });
    }

    private String getProfessorName(){
        return binding.textInputProfessorName.getText().toString().trim();
    }
    private int getSala(){
        return Integer.parseInt(binding.textInputSala.getText().toString().trim());
    }
    private int getPredio(){
        return Integer.parseInt(binding.textInputPredio.getText().toString().trim());
    }
    private String getEmail(){
        return binding.textInputProfessorEmail.getText().toString().trim();
    }
    private void saveData(){
        TcheOrganizaPersistence.getInstance().addTeacherToList(getProfessorName(), getEmail(), getPredio(), getSala());
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
