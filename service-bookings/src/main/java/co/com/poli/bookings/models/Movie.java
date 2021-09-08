package co.com.poli.bookings.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private Long id;
    private String tittle;
    private String director;
    private Integer rating;
}
