package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO trans(Product product) {
        return new ProductDTO(product.getName(),product.getDescription(),SubcategoryMapper.trans(product.getSubcategoryId()));
    }
}
