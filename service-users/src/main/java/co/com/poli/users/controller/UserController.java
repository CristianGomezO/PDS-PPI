package co.com.poli.users.controller;

import co.com.poli.users.entities.User;
import co.com.poli.users.models.Booking;
import co.com.poli.users.services.UserService;
import co.com.poli.commons.libraries.FormatMessage;
import co.com.poli.commons.libraries.Response;
import co.com.poli.commons.libraries.ResponseBuilder;
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
@RequestMapping(value="/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        userService.save(user);
        return builder.success(user);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user == null){
            return builder.success(null);
        }
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user == null){
            return builder.success(null);
        }
        String message = userService.findByUserId(user.getId());
        if(message.equals("Tiene reservas asociadas")) {
            return builder.success("El usuario que intenta eliminar tiene reservaciones asociadas");
        }
        userService.delete(user);
        return builder.success(user);
    }

    @GetMapping()
    public Response findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return builder.success(null);
        }
        return builder.success(users);
    }

}
