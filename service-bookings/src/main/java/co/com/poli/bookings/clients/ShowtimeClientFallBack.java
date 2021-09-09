package co.com.poli.bookings.clients;

import co.com.poli.bookings.models.Showtime;
import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimeClientFallBack implements ShowtimeClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findById(Long id) {
        Showtime showtime = new Showtime();
        return builder.success(showtime);
    }
}
