package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.entities.AttributeValue;
import org.springframework.stereotype.Component;

@Component
public class AttributeValueMapper {

    public static AttributeValueDTO trans(AttributeValue attributeValue) {
        return new AttributeValueDTO(attributeValue.getValue(), attributeValue.getProductAttributeId().getId());
    }
}
