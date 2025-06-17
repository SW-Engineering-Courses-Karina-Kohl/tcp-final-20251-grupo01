package tasks;

import java.time.LocalDate;

public class Lab extends Task{

    private String room;

    public  Lab(String name, String description, LocalDate date, boolean status, String room){
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