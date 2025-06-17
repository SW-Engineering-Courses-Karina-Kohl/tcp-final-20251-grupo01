package br.ufrgs.inf.tcp.tcheorganiza.ui.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentTasksBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.TupleTaskCourse;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters.TasksAdapter;

public class TasksFragment extends Fragment  implements View.OnClickListener {

    private FragmentTasksBinding binding;
    private TcheOrganizaPersistence persistence = TcheOrganizaPersistence.getInstance();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        List<TupleTaskCourse> tasks = persistence.getAllTaskByTupleTaskCourse();
        
        binding = FragmentTasksBinding.inflate(inflater, container, false);
        getActivity().setTitle("Atividades");

        RecyclerView recyclerViewTasks = binding.recyclerListAtividades;
        TasksAdapter tasksAdapter = new TasksAdapter(tasks);
        recyclerViewTasks.setAdapter(tasksAdapter);

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