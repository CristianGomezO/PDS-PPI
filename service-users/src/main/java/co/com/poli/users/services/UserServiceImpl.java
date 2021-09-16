package co.com.poli.users.services;

import co.com.poli.users.clients.BookingClient;
import co.com.poli.users.entities.User;
import co.com.poli.users.models.Booking;
import co.com.poli.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BookingClient bookingClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findByUserId(Long userid) {
        ModelMapper modelMapper = new ModelMapper();

        Booking booking = modelMapper.map(bookingClient.findByUserId(userid).getData(), Booking.class);

        return booking;
    }


}
