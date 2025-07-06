package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityPreferenceRuBinding;

public class PreferenceRuActivity extends AppCompatActivity {

    private ActivityPreferenceRuBinding binding;

    //Creating activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPreferenceRuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupDropdownRU();
        setButtonConcluido();
    }

    //Setting up dropdown menu
    private void setupDropdownRU(){
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_RU);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.dropdown_options_RU,
                android.R.layout.simple_dropdown_item_1line
        );
        dropdown.setAdapter(adapter);
    }

    //Setting up button
    private void setButtonConcluido(){
        binding.buttonConcluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(PreferenceRuActivity.this, MainActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }

}