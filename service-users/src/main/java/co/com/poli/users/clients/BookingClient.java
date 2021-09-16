package co.com.poli.users.clients;

import co.com.poli.commons.libraries.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-bookings", fallback = BookingClientFallBack.class)
public interface BookingClient {

    @GetMapping("/booking/userid/{userid}")
    Response findByUserId(@PathVariable("userid") Long userid);

}
