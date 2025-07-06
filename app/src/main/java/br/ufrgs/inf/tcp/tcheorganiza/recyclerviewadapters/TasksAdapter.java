package br.ufrgs.inf.tcp.tcheorganiza.recyclerviewadapters;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private String emptyMessage = "Ufa! Nenhuma tarefa pendente";

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

            itemView.setOnClickListener(v -> {
                if (viewType == VIEW_TYPE_NORMAL && tupleTaskCourse != null) {
                    showTaskDetailsDialog(v.getContext(), tupleTaskCourse);
                }
            });
        }
        private void showTaskDetailsDialog(Context context, TupleTaskCourse tupleTaskCourse) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_task_details, null);
            builder.setView(dialogView);
            TextView titleTextView = dialogView.findViewById(R.id.text_view_task_type);
            TextView dateTextView = dialogView.findViewById(R.id.text_view_task_date);
            TextView courseTextView = dialogView.findViewById(R.id.text_view_task_course);
            TextView descriptionTextView = dialogView.findViewById(R.id.text_view_task_description);
            TextView nameTaskTextView = dialogView.findViewById(R.id.text_view_task_name);
            TextView contentTaskTextView = dialogView.findViewById(R.id.text_view_task_content);
            TextView localTaskTextView = dialogView.findViewById(R.id.text_view_task_local);
            TextView contentTaskTitleTextView = dialogView.findViewById(R.id.text_view_task_content_title);

            Task task = tupleTaskCourse.getTask();
            String courseName = tupleTaskCourse.getCourseName();

            String taskTypeString;
            if (task instanceof Exam) {
                taskTypeString = "Prova";

                localTaskTextView.setVisibility(VISIBLE);
                localTaskTextView.setText(((Exam) task).getRoom().getOfficeDetails());

                contentTaskTitleTextView.setVisibility(VISIBLE);
                contentTaskTitleTextView.setText("Conteúdo da prova");

                contentTaskTextView.setText(((Exam) task).getContent());
                contentTaskTextView.setVisibility(VISIBLE);
            } else if (task instanceof Lab) {
                taskTypeString = "Laboratório";

                localTaskTextView.setText(((Lab) task).getRoom().getOfficeDetails());
                localTaskTextView.setVisibility(VISIBLE);

                contentTaskTitleTextView.setVisibility(GONE);
                contentTaskTextView.setVisibility(GONE);
            } else if (task instanceof Work) {
                taskTypeString = "Trabalho";

                localTaskTextView.setText("");
                localTaskTextView.setVisibility(GONE);

                contentTaskTitleTextView.setVisibility(GONE);
                contentTaskTextView.setText("");
                contentTaskTextView.setVisibility(GONE);
            } else {
                taskTypeString = "Tarefa";

                localTaskTextView.setVisibility(GONE);
                localTaskTextView.setText("");

                contentTaskTitleTextView.setVisibility(GONE);
                contentTaskTextView.setText("");
                contentTaskTextView.setVisibility(GONE);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = task.getDate().format(formatter);

            nameTaskTextView.setText(task.getName());

            titleTextView.setText(taskTypeString);
            dateTextView.setText(formattedDate);
            courseTextView.setText(courseName);
            Log.d("TasksAdapter", "Description: " + task.getDescription());
            descriptionTextView.setText(task.getDescription());


            builder.setView(dialogView);
            builder.setPositiveButton("Fechar", (dialog, which) -> dialog.dismiss());

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}