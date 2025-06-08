package subjectManager;
import tasks.*;
import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

public class subjectManager {
    public List<Task> allTasksOrdered = new ArrayList<>();
    for(Subjects i: subjects){
        allTasksOrdered.addAll(i.getTasks());
    }
    Collection.sort(allTasksOrdered);
    return allTasksOrdered;
}
