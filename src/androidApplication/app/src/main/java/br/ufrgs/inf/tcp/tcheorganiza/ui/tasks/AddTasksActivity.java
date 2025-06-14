package br.ufrgs.inf.tcp.tcheorganiza.ui.tasks;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ufrgs.inf.tcp.tcheorganiza.MainActivity;
import br.ufrgs.inf.tcp.tcheorganiza.NewTaskActivity;
import br.ufrgs.inf.tcp.tcheorganiza.PreferenceRuActivity;
import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddClassBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityAddTasksBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityNewTaskBinding;

public class AddTasksActivity extends AppCompatActivity {

    private ActivityAddTasksBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddTasksBinding.inflate(getLayoutInflater());
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
                Intent newAddTasksActivityIntent = new Intent(AddTasksActivity.this, MainActivity.class);
                startActivity(newAddTasksActivityIntent);
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