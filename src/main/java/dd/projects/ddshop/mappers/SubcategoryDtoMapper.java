package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryDtoMapper {

    public static Subcategory trans(SubcategoryDTO subcategoryDTO) {
        return new Subcategory();
    }
}
