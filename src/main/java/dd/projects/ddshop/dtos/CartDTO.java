package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDTO {

    private UserDTO userId;

    private double totalPrice;

    private List <CartEntryDTO> cartEntries;
}
