package dd.projects.ddshop.dtos;

import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class VariantDTO {

    private double price;

    private int availableQuantity;

    private Date addedDate;

    private int productId;

    public VariantDTO(Variant variant){
        this.setProductId(variant.getProductId().getId());
        this.setPrice(variant.getPrice());
        this.setAvailableQuantity(variant.getAvailableQuantity());
        this.setAddedDate(variant.getAddedDate());
    }

}
