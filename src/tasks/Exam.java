package tasks;

public class Exam extends Task{

    private String room;
    private String content;

    public Exam(String name, String description, int date, boolean status, String room, String content){
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
    
    public void printTask(String room, String content){
        System.out.println();
    }

    @Override
    public void printTask(String name, String description, int date, boolean status){
        if(status ==  true){
            System.out.println("A prova" + name + "foi finalizada");
        }
        else{
            System.out.println("A prova" + name + "ocorrera no dia" + date);
            System.out.println("Descricao:" + description);
        }
    }
}