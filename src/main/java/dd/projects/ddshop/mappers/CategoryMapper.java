package dd.projects.ddshop.mappers;
import dd.projects.ddshop.dtos.CategoryDTO;
import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CategoryMapper {

    public static CategoryDTO trans(Category category) {
        List<SubcategoryDTO> subcategoryDTOS = category.getSubcategory()
                .stream()
                .map(SubcategoryMapper::trans)
                .collect(toList());
        return new CategoryDTO(category.getName(), subcategoryDTOS);
    }
}
