package co.com.poli.bookings.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Showtime {
    private Long id;
    private Date date;
    private List<Long> moviesId;
}
