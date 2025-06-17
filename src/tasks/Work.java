package tasks;

import java.time.LocalDate;

public class Work extends Task{

    private String toDo;

    public Work(String name, String description, LocalDate date, boolean status, String toDo){
        super(name, description, date, status);
        this.toDo = toDo;
    }

    public String getToDo(){
        return toDo;
    }

    public void setToDo(String toDo){
        this.toDo = toDo;
    }
}