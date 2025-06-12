package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewClassBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityPreferenceRuBinding;

public class PreferenceRuActivity extends AppCompatActivity {

    private ActivityPreferenceRuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPreferenceRuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonConcluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(PreferenceRuActivity.this, MainActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
}