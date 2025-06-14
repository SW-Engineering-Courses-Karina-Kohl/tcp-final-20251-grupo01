package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class DisciplinasAdapter extends RecyclerView.Adapter<DisciplinasAdapter.DisciplinasViewHolder> {

    private DummyCourse[] courses;

    public DisciplinasAdapter(DummyCourse[] courses) {
        this.courses = courses;
    }

    @Override
    public int getItemCount() {
        return courses.length;
    }
    @NonNull
    @Override
    public DisciplinasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disciplina, parent, false);
        return new DisciplinasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinasViewHolder holder, int position) {
        holder.bind(courses[position]);
    }



    static class DisciplinasViewHolder extends RecyclerView.ViewHolder{

        private MaterialTextView courseTime;
        private MaterialTextView courseName;
        private MaterialTextView classroom;


        public DisciplinasViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTime = itemView.findViewById(R.id.text_view_horario_disciplina);
            courseName = itemView.findViewById(R.id.text_view_nome_disciplina);
            classroom = itemView.findViewById(R.id.text_view_sala_disciplina);
        }
        public void bind(DummyCourse course){
            courseTime.setText(course.courseTime);
            courseName.setText(course.courseName);
            classroom.setText(course.classroom);
        }
    }
}
