package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartEntryDTO {

    private int quantity;

    private double pricePerPiece;

    private double totalPricePerEntry;

    private int variantId;

    private int cartId;


}
