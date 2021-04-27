package model;

public class Room {
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getNrPers() {
        return nrPers;
    }

    private int id;
    private String description;
    private String type;
    private int nrPers;

    public Room(int id, String description, String type, int nrPers) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.nrPers = nrPers;
    }
}
