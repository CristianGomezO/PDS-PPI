package co.com.poli.users;

import co.com.poli.users.clients.BookingClient;
import co.com.poli.users.entities.User;
import co.com.poli.users.repositories.UserRepository;
import co.com.poli.users.services.UserService;
import co.com.poli.users.services.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@DataJpaTest
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;
    private BookingClient bookingclient;
    private UserService userService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository,bookingclient);

        User user = User.builder()
                .id(4L)
                .name("prueba")
                .lastName("apellido")
                .build();


        Mockito.when(userRepository.findById(4L)).thenReturn(Optional.of(user));
    }

    @Test
    public void when_findById_return_user(){
        User user = userService.findById(4L);
        Assertions.assertThat(user.getName()).isEqualTo("prueba");
    }
}
