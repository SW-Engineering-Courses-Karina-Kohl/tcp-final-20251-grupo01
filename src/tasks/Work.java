package tasks;

public class Work extends Task{

    private String toDo;

    public Work(String name, String description, int date, boolean status, String toDo){
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