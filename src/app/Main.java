package app;
import tasks.*;

public class Main{
    
    public static void main(String[] args) {

        Lab lab = new Lab("code Smells", "Analisar codigo mal estruturado e corrigir", 12122025, false, "lab 103");

        lab.printTask(lab.getName(), lab.getDescription(), lab.getDate(), lab.getStatus());
    }
}