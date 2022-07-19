package dd.projects.ddshop.dtos;

import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class VariantDTO {

    private double price;

    private int availableQuantity;

    private Date addedDate;

    private int productId;

    private List<Integer> assignedValues;

    public VariantDTO(Variant variant){
        this.setProductId(variant.getProductId().getId());
        this.setPrice(variant.getPrice());
        this.setAvailableQuantity(variant.getAvailableQuantity());
        this.setAddedDate(variant.getAddedDate());
    }

}
