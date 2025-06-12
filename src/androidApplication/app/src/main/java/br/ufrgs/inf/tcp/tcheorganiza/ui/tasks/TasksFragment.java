package br.ufrgs.inf.tcp.tcheorganiza.ui.tasks;

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
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentTasksBinding;

public class TasksFragment extends Fragment  implements View.OnClickListener {

    private FragmentTasksBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TasksViewModel tasksViewModel =
                new ViewModelProvider(this).get(TasksViewModel.class);

        binding = FragmentTasksBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupClickListener();
    }
    private void setupClickListener(){
        binding.buttonAddTasks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        launchAddTasks();
    }

    private void launchAddTasks() {
        Intent intent = new Intent(getContext(), AddTasksActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}