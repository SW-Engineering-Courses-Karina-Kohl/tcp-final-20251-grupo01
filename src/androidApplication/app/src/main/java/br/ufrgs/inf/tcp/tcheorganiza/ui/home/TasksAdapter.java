package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Exam;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Lab;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Task;
import br.ufrgs.inf.tcp.tcheorganiza.model.tasks.Work;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private List<Task> tasks;

    public TasksAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        holder.bind(tasks.get(position));
    }



    static class TasksViewHolder extends RecyclerView.ViewHolder{

        private MaterialTextView taskType;
        private MaterialTextView taskDate;
        private MaterialTextView taskTime;
        private MaterialTextView taskCourse;


        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            taskType = itemView.findViewById(R.id.text_view_tipo);
            taskDate = itemView.findViewById(R.id.text_view_date);
            taskTime = itemView.findViewById(R.id.text_view_horario);
            taskCourse = itemView.findViewById(R.id.text_view_disciplina);
        }
        public void bind(Task task){
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

            taskType.setText(taskTypeString);
            taskDate.setText(task.getDate()); // TODO: Fix, current getDate is int
            taskTime.setText(task.getDate()); //  TODO: Fix, current getDate is int
        }
    }
}
