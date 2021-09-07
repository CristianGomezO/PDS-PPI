package co.com.poli.showtimes.services;

import co.com.poli.showtimes.entities.Showtime;

import java.util.List;

public interface ShowtimeService {

    List<Showtime> findAll();
    void save(Showtime showtime);
    Showtime findByID(Long numberId);
    void updateShowtime(Showtime newShowtime, Showtime oldShowTime);
}
