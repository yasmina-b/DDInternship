package dd.projects.ddshop.dtos;

import dd.projects.ddshop.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    public UserDTO(User user) {
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setPhoneNumber(user.getPhoneNumber());
    }
}
