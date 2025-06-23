package  br.ufrgs.inf.tcp.tcheorganiza.model.tasks;

import org.threeten.bp.LocalDate;
import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;

public class Exam extends Task{

    private Office office;
    private String content;

    public Exam(String name, String description, LocalDate date, boolean done, Office office, String content){
        super(name, description, date, done);
        this.office = office;
        this.content = content;
    }

    public Office getRoom(){
        return office;
    }

    public String getContent(){
        return content;
    }
    public void setRoom(Office office){
        this.office = office;
    }

    public void setContent(String content){
        this.content = content;
    }


    
}