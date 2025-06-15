package courses;

public class Office {

    private int room;
    private int building;

    // METHODS =========================================================
    public String getOfficeDetails() {
        return "Sala " + room + ", Predio " + building;
    } 

    // CONSTUCTORS =========================================================
    public Office(int room, int building) {
        this.room = room;
        this.building = building;
    }

    // SETTERS =========================================================
    public void setRoom(int room) {
        if (room <= 0) {
            throw new IllegalArgumentException("Room number must be a positive integer");
        }
        this.room = room;
    }

    public void setBuilding(int building) {
        if (building <= 0) {
            throw new IllegalArgumentException("Building number must be a positive integer");
        }
        this.building = building;
    }

    // GETTERS =========================================================
    public int getRoom() {
        return room;
    }

    public int getBuilding() {
        return building;
    }
    
}