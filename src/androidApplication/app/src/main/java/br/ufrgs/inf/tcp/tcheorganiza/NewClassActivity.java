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
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;

public class NewClassActivity extends AppCompatActivity {

    private ActivityNewClassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(NewClassActivity.this, NewTaskActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }

}