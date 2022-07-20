package dd.projects.ddshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubcategoryDTO {

    private String name;

    private CategoryDTO categoryId;

    private int subcategoryId;


}
