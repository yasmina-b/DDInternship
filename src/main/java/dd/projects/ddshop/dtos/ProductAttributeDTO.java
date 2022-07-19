package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductAttributeDTO {

    private String name;

    private List <String> attributeValue;

    private List <Integer> subcategories;
}
