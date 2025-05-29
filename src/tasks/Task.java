package tasks;

public class Task{

    private String name;
    private String description;
    private int date;
    private boolean status;
    //are we use subject here?

    public Task(String name, String description, int date, boolean status){
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getDate(){
        return date;
    }

    //add this func
    public boolean getStatus(){
        return status;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDate(int date){
        this.date = date;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    //create a override to show different tasks
    public void printTask(String name, String description, int date, boolean status){
        if(status == true){
            System.out.println("A tarefa " + name + " foi finalizada.");
        }
        else{
            System.out.println("A tarefa " + name + " ocorrera no dia " + date);
            System.out.println("Descricao: " + description);
        }
    }
}