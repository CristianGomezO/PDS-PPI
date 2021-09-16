package co.com.poli.users.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-bookings")
public interface BookingClient {



}
