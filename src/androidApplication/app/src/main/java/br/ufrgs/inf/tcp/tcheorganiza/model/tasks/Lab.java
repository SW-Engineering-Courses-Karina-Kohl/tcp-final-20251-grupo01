package  br.ufrgs.inf.tcp.tcheorganiza.model.tasks;

import org.threeten.bp.LocalDate;

import br.ufrgs.inf.tcp.tcheorganiza.model.courses.Office;

public class Lab extends Task{

    private Office office;

    public  Lab(String name, String description, LocalDate date, boolean done, Office office){
        super(name, description, date, done);
        this.office = office;
    }

    public Office getRoom(){
        return office;
    }

    public void setRoom(Office office){
        this.office = office;
    }

}