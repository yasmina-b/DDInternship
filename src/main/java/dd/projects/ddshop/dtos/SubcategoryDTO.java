package dd.projects.ddshop.dtos;

import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubcategoryDTO {

    private String name;

    private int categoryId;


}
