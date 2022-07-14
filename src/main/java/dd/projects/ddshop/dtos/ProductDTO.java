package dd.projects.ddshop.dtos;

import dd.projects.ddshop.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private String description;

    private int subcategoryId;
}
