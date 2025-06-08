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

}