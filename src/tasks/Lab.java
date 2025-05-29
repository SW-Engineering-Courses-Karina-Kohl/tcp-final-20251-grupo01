package tasks;

public class Lab extends Task{

    private String room;

    public  Lab(String name, String description, int date, boolean status, String room){
        super(name, description, date, status);
        this.room = room;
    }

    public String getRoom(){
        return room;
    }

    public void setRoom(String room){
        this.room = room;
    }

    //@override
    public void printTask(String name, String description, int date, boolean status, String room){
        if(status == true){
            System.out.println("O laborario " + name + " foi finalizada.");
        }
        else{
            System.out.println("O laborario " + name + " ocorrera no dia " + date + " na sala " + room);
            System.out.println("Descricao: " + description);
        }
    }
}