package view;

import controller.cinema.CinemaController;
import controller.film.FilmController;
import controller.room.RoomController;
import model.Cinema;
import model.Film;
import model.Room;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FilmController fc = new FilmController();
//        ArrayList<Film> filmList = fc.getAll();
//        System.out.println(filmList);

//        Film f = new Film("BD la mare si la munte", "bd",
//                1974, "RO", 10);
//        fc.add(f);
//        System.out.println(fc.getByYear(1974));

        CinemaController cc = new CinemaController();
        ArrayList<Cinema> cinemaList = cc.getAll();
        System.out.println(cinemaList);

//        Cinema c = new Cinema("Movieplex", "Bucuresti", 20);
//        cc.add(c);
//        System.out.println(cc.getAll());

        RoomController rc = new RoomController();
        ArrayList<Room> roomList = rc.getAllByCinema(cinemaList.get(0));
        System.out.println(roomList);

        rc.add(new Room(1, 10, "VIP"));
        rc.add(new Room(1, 100, "IMAX 2"));

    }
}
