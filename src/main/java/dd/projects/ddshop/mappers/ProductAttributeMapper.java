package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.ProductAttribute;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProductAttributeMapper {

    public static ProductAttributeDTO trans(ProductAttribute productAttribute) {
        List<AttributeValueDTO> attributeValueDTOS = productAttribute.getAttributeValue()
                .stream()
                .map(AttributeValueMapper::trans)
                .collect(toList());
        return new ProductAttributeDTO(productAttribute.getName(), attributeValueDTOS);
    }
}
