package co.com.poli.bookings.clients;

import co.com.poli.bookings.models.Movie;
import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientFallBack implements MovieClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findById(Long id) {
        Movie movie = new Movie();
        return builder.success(movie);
    }
}
