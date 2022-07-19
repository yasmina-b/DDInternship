package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.ProductAttributeMapper;
import dd.projects.ddshop.repositories.AssignedValueRepository;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;

    private final SubcategoryRepository subcategoryRepository;

    private final AssignedValueRepository assignedValueRepository;

    @Autowired
    public ProductAttributeService (ProductAttributeRepository productAttributeRepository, SubcategoryRepository subcategoryRepository, AssignedValueRepository assignedValueRepository) {
       this.productAttributeRepository = productAttributeRepository;
       this.subcategoryRepository = subcategoryRepository;
       this.assignedValueRepository = assignedValueRepository;
    }
    public void createProductAttribute (ProductAttributeDTO productAttributeDTO) {
        ProductAttribute productAttribute = new ProductAttribute(productAttributeDTO.getName());

        for(String attribute: productAttributeDTO.getAttributeValue())
            productAttribute.getAttributeValue().add(new AttributeValue(attribute, productAttribute));

        for(int id : productAttributeDTO.getSubcategories())
            productAttribute.getSubcategories().add(subcategoryRepository.getReferenceById(id));

        productAttributeRepository.save(productAttribute);

        for (AttributeValue value : productAttribute.getAttributeValue())
            assignedValueRepository.save(new AssignedValue(value,productAttribute));

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
