package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.CartDTO;
import dd.projects.ddshop.dtos.CartEntryDTO;
import dd.projects.ddshop.entities.Cart;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CartMapper {

    public static CartDTO trans(Cart cart) {
        List<CartEntryDTO> cartEntryDTOS = cart.getCartEntry()
                .stream()
                .map(CartEntryMapper::trans)
                .collect(toList());
        return new CartDTO(UserMapper.trans(cart.getUserId()),cart.getTotalPrice(), cartEntryDTOS);
    }
}
