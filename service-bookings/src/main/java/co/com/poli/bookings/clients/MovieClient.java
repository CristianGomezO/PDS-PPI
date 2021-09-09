package co.com.poli.bookings.clients;

import co.com.poli.commons.libraries.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service-movies", fallback = MovieClientFallBack.class)
public interface MovieClient {

    @GetMapping("/movie/{id}")
    Response findById(@PathVariable("id") Long id);
}
