package br.ufrgs.inf.tcp.tcheorganiza.ui.more;

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
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentHomeBinding;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentTasksBinding;

public class MoreFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        MoreViewModel tasksViewModel =
//                new ViewModelProvider(this).get(MoreViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        setupClickListener();
//    }
//    private void setupClickListener(){
//        binding.buttonHoje.setOnClickListener(this);
//        binding.buttonDisciplinas.setOnClickListener(this);
//        binding.buttonTasks.setOnClickListener(this);
//        binding.buttonRU.setOnClickListener(this);
//        binding.buttonProfessores.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        launchAddTasks();
//    }
//
//    private void launchAddTasks() {
//        Intent intent = new Intent(getContext(), AddTasksActivity.class);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

}