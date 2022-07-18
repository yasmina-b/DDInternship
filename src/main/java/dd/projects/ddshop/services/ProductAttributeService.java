package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.CategoryDTO;
import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.CategoryMapper;
import dd.projects.ddshop.mappers.ProductAttributeMapper;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;

    @Autowired
    public ProductAttributeService (ProductAttributeRepository productAttributeRepository) {
       this.productAttributeRepository = productAttributeRepository;
    }
    public void createProductAttribute (ProductAttribute productAttribute) {
        productAttributeRepository.save(productAttribute);
    }

    public List<ProductAttributeDTO> getProductAttribute() {
        return productAttributeRepository.findAll()
                .stream()
                .map(ProductAttributeMapper::trans)
                .collect(toList());
    }

    public Optional<ProductAttribute> readProductAttribute(Integer productAttributeId) {
        return productAttributeRepository.findById(productAttributeId);
    }
    public void updateProductAttribute (int productAttributeId, ProductAttribute newProductAttribute) {
       ProductAttribute productAttribute = productAttributeRepository.findById(productAttributeId).get();
        productAttributeRepository.save(productAttribute);
    }
    public void deleteProductAttributeById (int id) {
        productAttributeRepository.deleteById(id);
    }
}
