package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductAttributeDTO {

    private String name;

    private List<AttributeValueDTO> attributeValue;

    private List<SubcategoryDTO> subcategories;

}