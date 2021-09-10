package co.com.poli.movies;

import co.com.poli.movies.entities.Movie;
import co.com.poli.movies.repositories.MovieRepository;
import co.com.poli.movies.services.MovieService;
import co.com.poli.movies.services.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@DataJpaTest
public class MoviesServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie movie = Movie.builder()
                .id(3L)
                .tittle("testtittle")
                .director("testdirector")
                .rating(4)
                .build();

        Mockito.when(movieRepository.findById(3L)).thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_user(){
        Movie movie = movieService.findByID(3L);
        Assertions.assertThat(movie.getTittle()).isEqualTo("testtittle");
    }
}
