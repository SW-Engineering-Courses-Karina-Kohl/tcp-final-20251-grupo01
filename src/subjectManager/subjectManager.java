package subjectManager;
import tasks.*;
import courses.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class SubjectManager {

    public List<Task> allTasksOrdered = new ArrayList<>();

    public List<Task> getAllTasksOrdered(List<Course> courses) {
        for(Course i: courses){
            allTasksOrdered.addAll(i.getTasks());
        }
        Collections.sort(allTasksOrdered, Comparator.comparing(Task::getDate));
        return allTasksOrdered;
    }
};