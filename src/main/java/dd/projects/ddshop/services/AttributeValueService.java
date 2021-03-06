package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.AttributeValueMapperImpl;
import dd.projects.ddshop.repositories.AttributeValueRepository;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;

    private final AttributeValueMapperImpl attributeValueMapper;

    private final ProductAttributeRepository productAttributeRepository;

    @Autowired
    public AttributeValueService (final AttributeValueRepository attributeValueRepository, final AttributeValueMapperImpl attributeValueMapper, final ProductAttributeRepository productAttributeRepository){
       this.attributeValueRepository = attributeValueRepository;
       this.attributeValueMapper = attributeValueMapper;
       this.productAttributeRepository = productAttributeRepository;
    }
    public static AttributeValue getAttributeValueFromDTO(AttributeValueDTO attributeValueDTO, ProductAttribute productAttribute){
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setValue(attributeValueDTO.getValue());
        attributeValue.setProductAttributeId(productAttribute);
        return attributeValue;

    }
    public void createAttributeValue (final AttributeValueDTO attributeValueDTO, final int id) {
        final ProductAttribute productAttribute = productAttributeRepository.getReferenceById(id);
        final AttributeValue attributeValue = new AttributeValue(attributeValueMapper.toAttributeValue(attributeValueDTO),productAttribute);
        attributeValueRepository.save(attributeValue);
    }
    public List<AttributeValueDTO> getAttributeValue() {
        return attributeValueRepository.findAll()
                .stream()
                .map(attributeValueMapper::toAttributeValueDTO)
                .collect(toList());
    }
    public void updateAttributeValue (int attributeValueId, AttributeValueDTO newAttributeValueDTO) {
        AttributeValue attributeValue = attributeValueRepository.findById(attributeValueId).get();
        attributeValue.setValue(newAttributeValueDTO.getValue());
        attributeValueRepository.save(attributeValue);
    }
    public void deleteAttributeValueById (final int id) {
        attributeValueRepository.deleteById(id);
    }
}
