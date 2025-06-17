package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentHomeBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.TupleTaskCourse;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.Utils;
import br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters.DisciplinasAdapter;
import br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters.TasksAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TcheOrganizaPersistence persistence = TcheOrganizaPersistence.getInstance();
    private final int maxNumOfTask = 5;

    private final String todayWeekDayInPortuguese = Utils.getTodayWeekDayInPortuguese();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        List<Course> todayCourses = persistence.getDisciplinasList().stream()
                .filter(course -> (long) course.getTodaySchedule().size() > 0)
                .collect(Collectors.toList());

        List<TupleTaskCourse> tasks = persistence.getAllTaskByTupleTaskCourse();

        if(tasks.size() > maxNumOfTask) {
            tasks = tasks.subList(0, maxNumOfTask);
        }

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        getActivity().setTitle("Hoje");

        RecyclerView recyclerViewCourses = binding.recyclerListDisciplinas;
        DisciplinasAdapter disciplinasAdapter = new DisciplinasAdapter(todayCourses);
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