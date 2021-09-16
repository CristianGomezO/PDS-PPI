package co.com.poli.bookings.repositories;

import co.com.poli.bookings.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking findById(String id);
    Booking findByUserId(String userid);
}
