package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentHomeBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.DiaDaSemana;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.Ru;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.TupleTaskCourse;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.Utils;
import br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters.DisciplinasAdapter;
import br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters.TasksAdapter;
import br.ufrgs.inf.tcp.tcheorganiza.ui.cardapio.RUMealCardViewFragment;

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
        ConstraintLayout root = binding.getRoot();
        getActivity().setTitle("Hoje");

        RecyclerView recyclerViewCourses = binding.recyclerListDisciplinas;
        DisciplinasAdapter disciplinasAdapter = new DisciplinasAdapter(todayCourses);
        disciplinasAdapter.setEmptyMessage("Nenhuma aula hoje! Aproveite o dia :)");
        recyclerViewCourses.setAdapter(disciplinasAdapter);

        RecyclerView recyclerViewTasks = binding.recyclerListAtividades;
        TasksAdapter tasksAdapter = new TasksAdapter(tasks);
        tasksAdapter.setEmptyMessage("Sem tarefas por enquanto. Aproveite o tempo livre!");
        recyclerViewTasks.setAdapter(tasksAdapter);

        Ru favoriteRU;
        try {
            favoriteRU = persistence.RUOrganizer.buscarRU(persistence.RUOrganizer.getNomeRuFavorito());
        } catch (Exception e) {
            if (!persistence.RUOrganizer.getRus().isEmpty()) {
                favoriteRU = persistence.RUOrganizer.getRus().get(0);
            } else {
                favoriteRU = null;
            }
        }

        DiaDaSemana todayWeekDay = getTodayWeekDay();

         MaterialTextView weekDayTextView = root.findViewById(R.id.todat_weekday_menu);
         weekDayTextView.setText(favoriteRU.getNome() + " - " + todayWeekDay.name());

        List<String> todaysLunch = favoriteRU.getCardapioAlmoco().getItens().get(todayWeekDay);
        List<String> todaysDinner = favoriteRU.getCardapioJanta().getItens().get(todayWeekDay);

        RUMealCardViewFragment fragment = new RUMealCardViewFragment();
        fragment.setMeals(todaysLunch, todaysDinner);
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.mealFragmentContainerView, fragment)
                .commit();

        return root;
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

    private DiaDaSemana getTodayWeekDay(){
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                return DiaDaSemana.SEGUNDA;
            case TUESDAY:
                return DiaDaSemana.TERCA;
            case WEDNESDAY:
                return DiaDaSemana.QUARTA;
            case THURSDAY:
                return DiaDaSemana.QUINTA;
            case FRIDAY:
                return DiaDaSemana.SEXTA;
            default:
               return DiaDaSemana.SEXTA;
        }
    }
}