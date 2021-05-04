package model;

public class Cinema {
    private int id;
    private String name;
    private String location;
    private int noRooms;

    public Cinema(String name, String location, int noRooms) {
        this.name = name;
        this.location = location;
        this.noRooms = noRooms;
    }

    public Cinema(int id, String name, String location, int noRooms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.noRooms = noRooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", noRooms=" + noRooms +
                '}';
    }
}
