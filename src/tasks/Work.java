package tasks;

public class Work extends Task{

    //change name, because we have a status on Task (superclass)
    //So to work we need a explanation about what need to do
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

    @Override
    public void printTask(String name, String description, int date, boolean status){
        if(status == true){
            System.out.println("O trabalho " + name + "foi finalizado.");
        }
        else{
            System.out.println("O trabalho " + name + " deve ser entregue até o dia " + date);
            System.out.println("Descricao: " + description);
        }
    }
}