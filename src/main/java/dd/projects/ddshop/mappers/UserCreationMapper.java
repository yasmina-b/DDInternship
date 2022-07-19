package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.UserCreationDTO;
import dd.projects.ddshop.entities.User;
import org.mapstruct.Mapper;

@Mapper
public class UserCreationMapper {
    public User sourceToDestination(UserCreationDTO userCreationDto) {
        User user = new User();
        user.setFirstName(userCreationDto.getFirstName());
        user.setLastName(userCreationDto.getLastName());
        user.setEmail(userCreationDto.getEmail());
        user.setPhoneNumber(userCreationDto.getPhoneNumber());
        user.setPassword(userCreationDto.getPassword());
        return user;
    }

}
