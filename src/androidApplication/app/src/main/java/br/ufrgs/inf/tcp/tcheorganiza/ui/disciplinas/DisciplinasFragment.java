package br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentDisciplinasBinding;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters.DisciplinasAdapter;

public class DisciplinasFragment extends Fragment  implements View.OnClickListener {

    private FragmentDisciplinasBinding binding;

    private TcheOrganizaPersistence persistence = TcheOrganizaPersistence.getInstance();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDisciplinasBinding.inflate(inflater, container, false);
        getActivity().setTitle("Disciplinas");

        RecyclerView recyclerViewCourses = binding.recyclerListDisciplinas;
        DisciplinasAdapter disciplinasAdapter = new DisciplinasAdapter(persistence.getDisciplinasList());
        recyclerViewCourses.setAdapter(disciplinasAdapter);

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