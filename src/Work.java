package tasks;

public class Work{

    //change name, because we have a status on Task (superclass)
    //So to work we need a explanation about what need to do
    private String toDo;

    public Work(String name, String description, int date, boolean status, String toDo){
        super(name, description, date, status);
        this.toDo = toDo;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    @override
    public void printTask(String name, String description, int date, boolean status, String toDo){
        if(status == 1){
            System.out.println("O trabalho" + name + "foi finalizado");
        }
        else{
            System.out.println("O trabalho" + name + "deve ser entregue até o dia" + date);
            System.out.println("Descricao:" + description + "ainda precisa ser feito" + toDo);
        }
    }
}