package co.com.poli.showtimes.controllers;

import co.com.poli.commons.libraries.FormatMessage;
import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
import co.com.poli.showtimes.entities.Showtime;
import co.com.poli.showtimes.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final FormatMessage message = new FormatMessage();
    private final ResponseBuilder builder = new ResponseBuilder();

    @PostMapping
    public Response save(@Valid @RequestBody Showtime showtime, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage(result));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @PutMapping("/{id}")
    public Response updateShowtime(@PathVariable("id") Long id, @RequestBody Showtime newShowtime){
        Showtime oldShowtime = showtimeService.findByID(id);
        if(oldShowtime == null){
            return builder.success(null);
        }
        showtimeService.updateShowtime(newShowtime, oldShowtime);
        return builder.success(newShowtime);
    }

    @GetMapping()
    public Response findAll(){
        List<Showtime> showtimes = showtimeService.findAll();
        if(showtimes.isEmpty()){
            return builder.success(null);
        }
        return builder.success(showtimes);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findByID(id);
        if(showtime == null){
            return builder.success(null);
        }
        return builder.success(showtime);
    }
}
