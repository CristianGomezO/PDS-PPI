package co.com.poli.movies.controllers;

import co.com.poli.commons.libraries.FormatMessage;
import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
import co.com.poli.movies.entities.Movie;
import co.com.poli.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage(result));
        }
        movieService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movie movie = movieService.findByID(id);
        if(movie == null){
            return builder.success(null);
        }
        movieService.delete(movie);
        return builder.success(movie);
    }

    @GetMapping()
    public Response findAll(){
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return builder.success(null);
        }
        return builder.success(movies);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movie movie = movieService.findByID(id);
        if(movie == null){
            return builder.success(null);
        }
        return builder.success(movie);
    }
}
