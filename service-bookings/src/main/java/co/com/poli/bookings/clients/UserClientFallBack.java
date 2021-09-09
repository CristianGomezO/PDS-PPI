package co.com.poli.bookings.clients;

import co.com.poli.bookings.models.User;
import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientFallBack implements UserClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findById(Long id) {
        User user = new User();
        return builder.success(user);
    }
}
