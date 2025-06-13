package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DummyCourse[] courses = {
                new DummyCourse("08:30", "Fundamentos de Banco de Dados", "116 - 43425"),
                new DummyCourse("10:30", "Técnicas de Construção de Programas", "112 - 43425"),
                new DummyCourse("13:30", "Complexidade de Algoritmos - B", "107 - 43425"),
        };
        DummyTasks[] tasks = {
                new DummyTasks("Entrega de trabalho", "24/06/25", "10:30","Técnicas de Construção de Programas"),
                new DummyTasks("Prova", "30/06/25", "08:30","Fundamentos de Banco de Dados")

        };
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        getActivity().setTitle("Hoje");


        RecyclerView recyclerViewCourses = binding.recyclerListDisciplinas;
        DisciplinasAdapter disciplinasAdapter = new DisciplinasAdapter(courses);
        recyclerViewCourses.setAdapter(disciplinasAdapter);

        RecyclerView recyclerViewTasks = binding.recyclerListAtividades;
        TasksAdapter tasksAdapter = new TasksAdapter(tasks);
        recyclerViewTasks.setAdapter(tasksAdapter);



        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}