package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentDisciplinasBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentHomeBinding;
import br.ufrgs.inf.tcp.tcheorganiza.ui.home.HomeViewModel;

public class DisciplinasFragment extends Fragment {

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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}