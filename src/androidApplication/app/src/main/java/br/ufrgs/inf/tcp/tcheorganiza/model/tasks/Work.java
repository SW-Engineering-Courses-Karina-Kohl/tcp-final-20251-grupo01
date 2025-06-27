package  br.ufrgs.inf.tcp.tcheorganiza.model.tasks;


import org.threeten.bp.LocalDate;

public class Work extends Task{

    private String toDo;

    public Work(String name, String description, LocalDate date, boolean done, String toDo){
        super(name, description, date, done);
        this.toDo = toDo;

    }

    public String getToDo(){
        return toDo;
    }

    public void setToDo(String toDo){
        this.toDo = toDo;
    }
}