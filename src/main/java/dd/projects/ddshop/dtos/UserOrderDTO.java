package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserOrderDTO {

    private UserDTO userId;

    private CartDTO cartDTO;

    private String paymentType;

    private AddressDTO deliveryAddress;

    private AddressDTO invoiceAddress;

    private double totalPrice;

    private Date orderDate;

}
