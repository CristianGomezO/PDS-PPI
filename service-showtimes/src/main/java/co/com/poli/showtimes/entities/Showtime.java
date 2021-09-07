package co.com.poli.showtimes.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Por favor ingrese una fecha con el formato YYYY-MM-DD")
    @Column(name = "date")
    private Date date;

    @ElementCollection
    @Column(name = "movies_id")
    private List<Long> movies;

}
