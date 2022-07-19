package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.CartEntryDTO;
import dd.projects.ddshop.entities.CartEntry;
import org.springframework.stereotype.Component;

@Component
public class CartEntryMapper {

    public static CartEntryDTO trans (CartEntry cartEntry){
        return new CartEntryDTO(cartEntry.getQuantity(),cartEntry.getPricePerPiece(),cartEntry.getTotalPricePerEntry(),cartEntry.getVariantId().getId(),cartEntry.getCartId().getId());

    }
}
