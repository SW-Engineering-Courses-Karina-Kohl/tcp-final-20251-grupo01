package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddClassBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewClassBinding;

public class AddClassActivity extends AppCompatActivity {

    private ActivityAddClassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}