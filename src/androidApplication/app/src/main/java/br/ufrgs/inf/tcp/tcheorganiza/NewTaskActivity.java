package br.ufrgs.inf.tcp.tcheorganiza;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityMainBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;

public class NewTaskActivity extends AppCompatActivity {

    private ActivityNewTaskBinding binding;

    //Creating activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupDropdownTipo();
        setupDesignSearchBox();
        setButtonContinuar();
        setButtonAdicionar();


    }

    //Dropdown "Tipo"
    private void setupDropdownTipo(){
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_tipo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.dropdown_options_tipo_atividade,
                android.R.layout.simple_dropdown_item_1line
        );
        dropdown.setAdapter(adapter);
    }
    private void resetDropdownTipo(){
        AutoCompleteTextView dropdown = findViewById(R.id.dropdown_menu_tipo);
        dropdown.setText("",false);
    }

    //Search box for "Disciplinas"
    private void setupDesignSearchBox(){
        SearchView searchView = findViewById(R.id.search_view_disciplina);

        AutoCompleteTextView searchText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchText.setTypeface(Typeface.SANS_SERIF);

        searchText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        theme.resolveAttribute(android.R.attr.textColorHint, typedValue, true);
        searchText.setHintTextColor(ContextCompat.getColor(this, typedValue.resourceId));
    }

    //Setting up buttons
    private void setButtonContinuar(){
        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newTaskActivityIntent = new Intent(NewTaskActivity.this, PreferenceRuActivity.class);
                startActivity(newTaskActivityIntent);
            }
        });
    }
    private void setButtonAdicionar(){
        binding.buttonAddTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ADICIONAR FUNÇÃO AQUI PARA PEGAR AS INFORMAÇÕES
                clearTextFields();
            }
        });
    }

    //Clearing fields for next Task to be add
    private void clearTextFields(){
        binding.textInputNomeAtividade.setText("");
        binding.textInputNomeAtividade.clearFocus();


        binding.textInputData.setText("");
        binding.textInputData.clearFocus();


        resetDropdownTipo();
        binding.textInputDropdownTipo.clearFocus();

        binding.searchViewDisciplina.setQuery("", false);
        binding.searchViewDisciplina.clearFocus();

        binding.textInputDescricao.setText("");
        binding.textInputDescricao.clearFocus();
    }
}