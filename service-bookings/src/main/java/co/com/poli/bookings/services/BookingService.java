package co.com.poli.bookings.services;

import co.com.poli.bookings.entities.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
    void updateBooking(Booking newBooking, Booking oldBooking);
}
