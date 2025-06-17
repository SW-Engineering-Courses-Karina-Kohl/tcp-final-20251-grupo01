package tasks;

import java.time.LocalDate;

public class Exam extends Task{

    private String room;
    private String content;

    public Exam(String name, String description, LocalDate date, boolean status, String room, String content){
        super(name, description, date, status);
        this.room = room;
        this.content = content;
    }

    public String getRoom(){
        return room;
    }

    public String getContent(){
        return content;
    }

    public void setRoom(String room){
        this.room = room;
    }

    public void setContent(String content){
        this.content = content;
    }
    
}