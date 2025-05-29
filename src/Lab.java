package tasks;

public class Lab{

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

    @override
    public void printTask(){
        if(status == 1){
            System.out.println("O laborario" + name + "foi finalizada");
        }
        else{
            System.out.println("O laboratio" + name + "ocorrera no dia" + date + "na sala" + sala);
            System.out.println("Descricao:" + description);
        }
    }
}