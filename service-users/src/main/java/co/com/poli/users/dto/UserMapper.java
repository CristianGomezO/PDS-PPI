package co.com.poli.users.dto;

import co.com.poli.users.entities.User;

public class UserMapper {



        public UserDto toDto(User user) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setLastName(user.getLastName());

            return dto;
        }

        public User toEntity(UserDto dto) {
            User user = new User();
            user.setId(dto.getId());
            user.setName(dto.getName());
            user.setLastName(dto.getLastName());

            return user;
        }

}
