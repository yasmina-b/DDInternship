package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignedValueDTO {

    private ProductAttributeVariantDTO productId;

    private AttributeValueDTO attributeId;

    private int id;
}
