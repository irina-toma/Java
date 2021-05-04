package model;

public class Room {
    private int id;
    private int cinemaId;
    private int noSeats;
    private String type;

    public Room(int cinemaId, int noSeats, String type) {
        this.cinemaId = cinemaId;
        this.noSeats = noSeats;
        this.type = type;
    }

    public Room(int id, int cinemaId, int noSeats, String type) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.noSeats = noSeats;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", noSeats=" + noSeats +
                ", type='" + type + '\'' +
                '}';
    }
}
