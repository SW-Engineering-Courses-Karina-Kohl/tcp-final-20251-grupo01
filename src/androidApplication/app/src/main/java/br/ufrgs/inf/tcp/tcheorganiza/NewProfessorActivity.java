package br.ufrgs.inf.tcp.tcheorganiza;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewProfessorBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityStartingPageBinding;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;

public class NewProfessorActivity extends AppCompatActivity {

    private ActivityNewProfessorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpButtonAdicionar();
        setUpButtonContinuar();

    }
    private void setUpButtonContinuar(){
        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(NewProfessorActivity.this, NewClassActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
    private void setUpButtonAdicionar(){
        binding.buttonAddProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewProfessor();
            }
        });
    }
    private void saveInPersistence(String profName, String profEmail, int profPredio, int profSala){

        TcheOrganizaPersistence.getInstance().addTeacherToList(profName,profEmail,profPredio,profSala);
    }

    private void saveNewProfessor(){
        String professorName = binding.textInputProfessorName.getText().toString().trim();
        String professorPredio = binding.textInputPredio.getText().toString().trim();
        String professorSala = binding.textInputSala.getText().toString().trim();
        String professorEmail = binding.textInputProfessorEmail.getText().toString().trim();

        //Se algum campo não for preenchido, pede para preencher (nesse caso é porque não tem como editar os professores)
        if(professorName.isEmpty() || professorEmail.isEmpty() || professorPredio.isEmpty() || professorSala.isEmpty()) {
            new AlertDialog.Builder(NewProfessorActivity.this)
                    .setMessage("Por favor, preencha todos os campos!")
                    .setPositiveButton("OK", (dialog, which) -> {
                    })
                    .show();

        } else {
            int profPredio = Integer.parseInt(professorPredio);
            int profSala = Integer.parseInt(professorSala);
            saveInPersistence(professorName,professorEmail,profPredio,profSala);

            new AlertDialog.Builder(NewProfessorActivity.this)
                    .setMessage("Professor(a) adicionado(a) com sucesso!")
                    .setPositiveButton("OK", (dialog, which) -> {
                    clearTextFields();})
                    .show();
        }

    }
    private void clearTextFields() {
        binding.textInputProfessorName.setText("");
        binding.textInputProfessorName.clearFocus();

        binding.textInputPredio.setText("");
        binding.textInputPredio.clearFocus();

        binding.textInputPredio.setText("");
        binding.textInputPredio.clearFocus();

        binding.textInputSala.setText("");
        binding.textInputSala.clearFocus();

        binding.textInputProfessorEmail.setText("");
        binding.textInputProfessorEmail.clearFocus();
    }
}