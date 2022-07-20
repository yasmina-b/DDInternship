package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private String streetLine;

    private int postalCode;

    private String city;

    private String county;

    private String country;
}
