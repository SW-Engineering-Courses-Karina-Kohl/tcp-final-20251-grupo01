package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentDisciplinasBinding;

public class DisciplinasFragment extends Fragment  implements View.OnClickListener {

    private FragmentDisciplinasBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DisciplinasViewModel disciplinaViewModel =
                new ViewModelProvider(this).get(DisciplinasViewModel.class);

        binding = FragmentDisciplinasBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupClickListener();
    }
    private void setupClickListener(){
        binding.buttonAddDisciplinas.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        launchAddDisciplinas();
    }

    private void launchAddDisciplinas() {
        Intent intent = new Intent(getContext(), AddClassActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}