package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRoleDTO {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String role;
}
