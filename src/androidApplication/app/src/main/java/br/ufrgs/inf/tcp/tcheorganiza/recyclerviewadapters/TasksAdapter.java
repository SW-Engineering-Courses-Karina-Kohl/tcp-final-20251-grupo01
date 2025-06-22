package br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Exam;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Lab;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.TupleTaskCourse;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Work;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_EMPTY = 1;

    private List<TupleTaskCourse> tasks;
    private boolean isEmpty = false;
    private String emptyMessage = "Nenhuma tarefa pendente";

    public TasksAdapter(List<TupleTaskCourse> tasks) {
        this.tasks = tasks;
    }

    public void setEmptyMessage(String message) {
        this.emptyMessage = message;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        int count = tasks.size();
        isEmpty = count == 0;
        return isEmpty ? 1 : count;
    }

    @Override
    public int getItemViewType(int position) {
        return isEmpty ? VIEW_TYPE_EMPTY : VIEW_TYPE_NORMAL;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_EMPTY) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_state, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        }
        return new TasksViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        if (isEmpty) {
            holder.bind(null, emptyMessage);
        } else {
            holder.bind(tasks.get(position), emptyMessage);
        }
    }

    static class TasksViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView taskType;
        private MaterialTextView taskDate;
        private MaterialTextView taskCourse;
        private MaterialTextView emptyTextView;
        private int viewType;

        public TasksViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;

            if (viewType == VIEW_TYPE_NORMAL) {
                taskType = itemView.findViewById(R.id.text_view_tipo);
                taskDate = itemView.findViewById(R.id.text_view_date);
                taskCourse = itemView.findViewById(R.id.text_view_disciplina);
            } else {
                emptyTextView = itemView.findViewById(R.id.text_view_empty_state);
            }
        }

        public void bind(TupleTaskCourse tupleTaskCourse, String emptyMessage) {
            if (viewType == VIEW_TYPE_EMPTY) {
                emptyTextView.setText(emptyMessage);
                return;
            }

            Task task = tupleTaskCourse.getTask();
            String courseName = tupleTaskCourse.getCourseName();

            String taskTypeString;
            if (task instanceof Exam) {
                taskTypeString = "Prova";
            } else if (task instanceof Lab) {
                taskTypeString = "Laboratório";
            } else if (task instanceof Work) {
                taskTypeString = "Trabalho";
            } else {
                taskTypeString = "Tarefa";
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = task.getDate().format(formatter);

            taskType.setText(taskTypeString);
            taskDate.setText(formattedDate);
            taskCourse.setText(courseName);
        }
    }
}