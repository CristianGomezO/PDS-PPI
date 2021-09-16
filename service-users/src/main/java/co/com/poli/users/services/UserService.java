package co.com.poli.users.services;

import co.com.poli.users.entities.User;
import co.com.poli.users.models.Booking;

import java.util.List;

public interface UserService {

    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);
    String findByUserId(Long userid);
}
