package co.com.poli.movies.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "director")
    private String director;

    @Column(name = "rating")
    private Integer rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
