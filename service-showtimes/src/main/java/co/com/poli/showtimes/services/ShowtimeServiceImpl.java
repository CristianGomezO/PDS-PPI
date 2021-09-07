package co.com.poli.showtimes.services;

import co.com.poli.showtimes.entities.Showtime;
import co.com.poli.showtimes.repositories.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService{

    private final ShowtimeRepository showtimeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findByID(Long numberId) {
        return showtimeRepository.findById(numberId).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateShowtime(Showtime newShowtime, Showtime oldShowtime) {
        oldShowtime.setDate(newShowtime.getDate());
        oldShowtime.setMovies(newShowtime.getMovies());
        showtimeRepository.save(oldShowtime);
    }
}
