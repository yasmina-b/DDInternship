package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class VariantDTO {

    private double price;

    private int availableQuantity;

    private Date addedDate;

    public ProductDTO productId;

    private List<AssignedValueDTO> assignedValues;

}
