package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class NewCourseFragment extends Fragment {

    private ViewGroup courseHourList;
    private int fragmentIdCounter = 0;

    public NewCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root  = inflater.inflate(R.layout.fragment_new_course, container, false);

        View newCourseHourButton = root.findViewById(R.id.buttonAddHour);
        courseHourList = root.findViewById(R.id.courseHourList);

        newCourseHourButton.setOnClickListener(v -> addCourseHour());

        return root;
    }


    private void addCourseHour() {
        // Cria um novo container para o fragmento
        FrameLayout container = new FrameLayout(requireContext());
        int containerId = View.generateViewId();  // Gera ID único
        container.setId(containerId);
        courseHourList.addView(container);

        // Adiciona o fragmento
        getChildFragmentManager()
                .beginTransaction()
                .add(containerId, new CourseHourFragment())
                .commit();
    }
}