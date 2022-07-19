package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.entities.User;
import org.mapstruct.Mapper;

@Mapper
public class UserMapper {

   public static User sourceToDestination(UserDTO userDto) {
       User user = new User();
       user.setFirstName(userDto.getFirstName());
       user.setLastName(userDto.getLastName());
       user.setEmail(userDto.getEmail());
       user.setPhoneNumber(userDto.getPhoneNumber());
       return user;
   }

   public static UserDTO trans (User user){
       return new UserDTO(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber());
   }


}
