package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreationDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;
}
