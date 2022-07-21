package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.ProductAttributeMapperImpl;
import dd.projects.ddshop.repositories.AssignedValueRepository;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;

    private final SubcategoryRepository subcategoryRepository;

    private final AssignedValueRepository assignedValueRepository;

    private final ProductAttributeMapperImpl productAttributeMapper;

    @Autowired
    public ProductAttributeService (final ProductAttributeRepository productAttributeRepository, final SubcategoryRepository subcategoryRepository, final AssignedValueRepository assignedValueRepository, final ProductAttributeMapperImpl productAttributeMapper) {
       this.productAttributeRepository = productAttributeRepository;
       this.subcategoryRepository = subcategoryRepository;
       this.assignedValueRepository = assignedValueRepository;
       this.productAttributeMapper = productAttributeMapper;
    }
    public void createProductAttribute (final ProductAttributeDTO productAttributeDTO) {
        ProductAttribute productAttribute = new ProductAttribute(productAttributeDTO.getName());

        for(AttributeValueDTO attribute: productAttributeDTO.getAttributeValue())
            productAttribute.getAttributeValue().add(new AttributeValue(attribute.getValue(), productAttribute));

        for(SubcategoryDTO id : productAttributeDTO.getSubcategories())
            productAttribute.getSubcategories().add(subcategoryRepository.getReferenceById(id.getId()));

        productAttributeRepository.save(productAttribute);

        for (AttributeValue value : productAttribute.getAttributeValue())
            assignedValueRepository.save(new AssignedValue(value,productAttribute));

    }
    public List<ProductAttributeDTO> getProductAttribute() {
        return productAttributeRepository.findAll()
                .stream()
                .map(productAttributeMapper::toProductAttributeDTO)
                .collect(toList());
    }

    public ProductAttribute readProductAttribute(Integer productAttributeId) {
        return productAttributeRepository.getReferenceById(productAttributeId);
    }
    public void updateProductAttribute (int productAttributeId, ProductAttributeDTO newProductAttributeDTO) {
       ProductAttribute productAttribute = productAttributeRepository.getReferenceById(productAttributeId);
       productAttributeRepository.save(productAttribute);
    }
    public void deleteProductAttributeById (int id) {
        productAttributeRepository.deleteById(id);
    }
}
