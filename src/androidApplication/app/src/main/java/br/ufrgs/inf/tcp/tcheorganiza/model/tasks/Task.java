package  br.ufrgs.inf.tcp.tcheorganiza.model.tasks;


import org.threeten.bp.LocalDate;

public class Task{

    private String name;
    private String description;
    private LocalDate date;
    private boolean done;

    public Task(String name, String description, LocalDate date, boolean done){
        this.name = name;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public LocalDate getDate(){
        return date;
    }

    public boolean getDone(){
        return done;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setDone(boolean done){
        this.done = done;
    }

}