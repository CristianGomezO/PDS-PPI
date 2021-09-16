package co.com.poli.bookings.services;

import co.com.poli.bookings.clients.MovieClient;
import co.com.poli.bookings.clients.ShowtimeClient;
import co.com.poli.bookings.clients.UserClient;
import co.com.poli.bookings.entities.Booking;
import co.com.poli.bookings.models.Movie;
import co.com.poli.bookings.models.Showtime;
import co.com.poli.bookings.models.User;
import co.com.poli.bookings.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final MovieClient movieClient;
    private final ShowtimeClient showtimeClient;
    private final UserClient userClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {

        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userClient.findById(booking.getUserid()).getData(), User.class);
        booking.setUser(user);

        Showtime showtime =
                modelMapper.map(showtimeClient.findById(booking.getShowtimeid()).getData(), Showtime.class);
        booking.setShowtime(showtime);

        List<Long> movieList = booking.getMovies_id().stream()
                .map(movieItem -> {
                    Movie movie = modelMapper.map(movieClient.findById(movieItem).getData(), Movie.class);
                    booking.setMovie(movie);
                    return movieItem;
                }).collect(Collectors.toList());

        bookingRepository.save(booking);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBooking(Booking newBooking, Booking oldBooking) {
        oldBooking.setUserid(newBooking.getUserid());
        oldBooking.setShowtimeid(newBooking.getShowtimeid());
        oldBooking.setMovies_id(newBooking.getMovies_id());
        bookingRepository.save(oldBooking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userClient.findById(booking.getUserid()).getData(), User.class);
        booking.setUser(user);

        Showtime showtime =
                modelMapper.map(showtimeClient.findById(booking.getShowtimeid()).getData(), Showtime.class);
        booking.setShowtime(showtime);

        List<Long> movieList = booking.getMovies_id().stream()
                .map(movieItem -> {
                    Movie movie = modelMapper.map(movieClient.findById(movieItem).getData(), Movie.class);
                    booking.setMovie(movie);
                    return movieItem;
                }).collect(Collectors.toList());

        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByUserid(Long id) {
        Booking booking = bookingRepository.findByUserid(id);
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userClient.findById(booking.getUserid()).getData(), User.class);
        booking.setUser(user);

        Showtime showtime =
                modelMapper.map(showtimeClient.findById(booking.getShowtimeid()).getData(), Showtime.class);
        booking.setShowtime(showtime);

        List<Long> movieList = booking.getMovies_id().stream()
                .map(movieItem -> {
                    Movie movie = modelMapper.map(movieClient.findById(movieItem).getData(), Movie.class);
                    booking.setMovie(movie);
                    return movieItem;
                }).collect(Collectors.toList());


        return bookingRepository.findByUserid(id);
    }


}
