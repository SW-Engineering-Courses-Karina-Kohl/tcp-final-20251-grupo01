package br.ufrgs.inf.tcp.tcheorganiza.ui.professor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddProfessorBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityProfessorBinding;

public class ProfessorActivity extends AppCompatActivity {

    private ActivityProfessorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}