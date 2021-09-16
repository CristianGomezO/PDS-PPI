package co.com.poli.users;

import co.com.poli.users.dto.UserDto;
import co.com.poli.users.entities.User;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testModelMapperToEntity() {

        UserDto dto = new UserDto(6L,"pedro","perez");


        User user = modelMapper.map(dto, User.class);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getName(), dto.getName());
        assertEquals(user.getLastName(), dto.getLastName());
    }

    @Test
    public void testModelMapperToDto() {
        User user = new User(5L,"carlos","ruiz");

        UserDto dto = modelMapper.map(user, UserDto.class);

        assertEquals(dto.getId(), user.getId());
        assertEquals(dto.getName(), user.getName());
        assertEquals(dto.getLastName(), user.getLastName());
    }
}


