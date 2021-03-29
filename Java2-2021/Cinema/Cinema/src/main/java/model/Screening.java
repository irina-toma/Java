package model;

public class Screening {
    private int id;
    private int filmId;
    private int roomId;
    private String type;
    private int hours;

    public Screening(int id, int filmId, int roomId, String type, int hours) {
        this.id = id;
        this.filmId = filmId;
        this.roomId = roomId;
        this.type = type;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
