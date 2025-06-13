package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private DummyTasks[] tasks;

    public TasksAdapter(DummyTasks[] tasks) {

        this.tasks = tasks;
    }

    @Override
    public int getItemCount() {

        return tasks.length;
    }
    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        holder.bind(tasks[position]);
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
        public void bind(DummyTasks task){
            taskType.setText(task.taskType);
            taskDate.setText(task.taskDate);
            taskTime.setText(task.taskTime);
            taskCourse.setText(task.taskCourse);
        }
    }
}
