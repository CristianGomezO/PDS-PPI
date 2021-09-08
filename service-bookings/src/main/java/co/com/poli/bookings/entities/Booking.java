package co.com.poli.bookings.entities;


import co.com.poli.bookings.models.Movie;
import co.com.poli.bookings.models.Showtime;
import co.com.poli.bookings.models.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;


    @NotEmpty(message = "El id del usuario no puede ser vacio")
    @Column(name = "userid", nullable = false)
    private Long userid;

    @Transient
    private User user;

    @NotEmpty(message = "El id de showtime no puede ser vacio")
    @Column(name = "showtimeid", nullable = false)
    private Long showtimeid;

    @Transient
    private Showtime showtime;

    @ElementCollection
    @Column(name = "movies_id")
    private List<Long> movies;

    @Transient
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
