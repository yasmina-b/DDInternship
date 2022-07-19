package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.entities.Subcategory;
import org.springframework.stereotype.Component;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProductAttributeMapper {

    public static ProductAttributeDTO trans(ProductAttribute productAttribute) {
        List<String> attributeValueDTOS = productAttribute.getAttributeValue()
                .stream()
                .map(ProductAttributeMapper::transform2)
                .collect(toList());
        List<Integer> attributeValueDTOS2 = productAttribute.getSubcategories()
                .stream()
                .map(ProductAttributeMapper::transform)
                .collect(toList());
        return new ProductAttributeDTO(productAttribute.getName(), attributeValueDTOS, attributeValueDTOS2);
    }

    public static Integer transform(Subcategory subcategory) {
        return subcategory.getId();
    }

    public static String transform2(AttributeValue attributeValue) {
        return attributeValue.getValue();
    }


}
