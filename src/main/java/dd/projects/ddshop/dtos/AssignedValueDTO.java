package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignedValueDTO {

    private ProductAttributeDTO productAttributeId;

    private AttributeValueDTO attributeValueId;

    private int assignedValueId;
}
