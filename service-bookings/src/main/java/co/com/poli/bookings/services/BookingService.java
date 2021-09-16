package co.com.poli.bookings.services;

import co.com.poli.bookings.entities.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
    Booking findByUserId(Long id);
    void updateBooking(Booking newBooking, Booking oldBooking);
}
