package co.com.poli.bookings.controller;

import co.com.poli.bookings.entities.Booking;
import co.com.poli.bookings.services.BookingService;
import co.com.poli.bookings.utils.ErrorMessage;
import co.com.poli.bookings.utils.Response;
import co.com.poli.bookings.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Booking booking, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage((result)));
        }
        bookingService.save(booking);
        return builder.success(booking);
    }

    @PutMapping("/{id}")
    public Response updateBooking(@PathVariable("id") Long id, @RequestBody Booking newBooking){
        Booking oldBooking = bookingService.findById(id);
        if(oldBooking == null){
            return builder.success(null);
        }
        bookingService.updateBooking(newBooking, oldBooking);
        return builder.success(newBooking);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return builder.success(null);
        }
        return builder.success(booking);
    }


    @GetMapping()
    public Response findAll(){
        List<Booking> bookings = bookingService.findAll();
        if(bookings.isEmpty()){
            return builder.success(null);
        }
        return builder.success(bookings);
    }




    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try{
            json = objectMapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }
}
