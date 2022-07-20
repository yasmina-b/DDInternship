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

    private ProductDTO productId;

    private List<AssignedValueDTO> assignedValues;

}
