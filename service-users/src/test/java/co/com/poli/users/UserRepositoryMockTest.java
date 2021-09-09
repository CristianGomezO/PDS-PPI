package co.com.poli.users;

import co.com.poli.users.entities.User;
import co.com.poli.users.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryMockTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findAll_return_listUsers(){
        User user = User.builder()
                .name("usertest")
                .lastName("testlastname")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(2);

    }
}
