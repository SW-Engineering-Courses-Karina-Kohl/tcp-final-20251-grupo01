package br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Course;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Schedule;

public class DisciplinasAdapter extends RecyclerView.Adapter<DisciplinasAdapter.DisciplinasViewHolder> {

    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_EMPTY = 1;

    private List<Course> todayCourses;
    private boolean isEmpty = false;
    private String emptyMessage = "Nenhuma disciplina hoje";

    public DisciplinasAdapter(List<Course> courses) {
        this.todayCourses = courses;
    }

    public void setEmptyMessage(String message) {
        this.emptyMessage = message;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        int count = todayCourses.size();
        isEmpty = count == 0;
        return isEmpty ? 1 : count;
    }

    @Override
    public int getItemViewType(int position) {
        return isEmpty ? VIEW_TYPE_EMPTY : VIEW_TYPE_NORMAL;
    }

    @NonNull
    @Override
    public DisciplinasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_EMPTY) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_state, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disciplina, parent, false);
        }
        return new DisciplinasViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinasViewHolder holder, int position) {
        if (isEmpty) {
            holder.bind(null, emptyMessage);
        } else {
            holder.bind(todayCourses.get(position), emptyMessage);
        }
    }

    static class DisciplinasViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView courseTime;
        private MaterialTextView courseName;
        private MaterialTextView classroom;
        private MaterialTextView emptyTextView;
        private int viewType;

        public DisciplinasViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;

            if (viewType == VIEW_TYPE_NORMAL) {
                courseTime = itemView.findViewById(R.id.text_view_horario_disciplina);
                courseName = itemView.findViewById(R.id.text_view_nome_disciplina);
                classroom = itemView.findViewById(R.id.text_view_sala_disciplina);
            } else {
                emptyTextView = itemView.findViewById(R.id.text_view_empty_state);
            }
        }

        public void bind(Course course, String emptyMessage) {
            if (viewType == VIEW_TYPE_EMPTY) {
                emptyTextView.setText(emptyMessage);
                return;
            }

            courseName.setText(course.getName());

            List<Schedule> todaySchedules = course.getTodaySchedule();
            if (!todaySchedules.isEmpty()) {
                Schedule todaySchedule = todaySchedules.get(0);
                classroom.setText(todaySchedule.getOffice().getOfficeDetails().toString());
                courseTime.setText(todaySchedule.getBeginTime().toString());
            }
        }
    }
}