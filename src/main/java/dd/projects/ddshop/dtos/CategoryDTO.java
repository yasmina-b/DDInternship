package dd.projects.ddshop.dtos;

import dd.projects.ddshop.entities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryDTO {

    private String name;

    private List <SubcategoryDTO> subcategory;
}
