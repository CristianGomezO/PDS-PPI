package co.com.poli.users.clients;

import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
import co.com.poli.users.models.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingClientFallBack implements BookingClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findByUserId(Long userid) {
        Booking booking = new Booking();
        return builder.success(booking);
    }
}
