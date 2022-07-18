package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.AttributeValueMapper;
import dd.projects.ddshop.repositories.AttributeValueRepository;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;

    AttributeValueMapper attributeValueMapper = new AttributeValueMapper();

    @Autowired
    public AttributeValueService (AttributeValueRepository attributeValueRepository){
       this.attributeValueRepository = attributeValueRepository;
    }

    public static AttributeValue getAttributeValueFromDTO(AttributeValueDTO attributeValueDTO, ProductAttribute productAttribute){
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setValue(attributeValueDTO.getValue());
        attributeValue.setProductAttributeId(productAttribute);
        return attributeValue;

    }

    public void createAttributeValue (AttributeValueDTO attributeValueDTO,ProductAttribute productAttribute) {
        AttributeValue attributeValue = getAttributeValueFromDTO(attributeValueDTO,productAttribute);
       attributeValueRepository.save(attributeValue);
    }

    public List<AttributeValueDTO> getAttributeValue() {
        return attributeValueRepository.findAll()
                .stream()
                .map(AttributeValueMapper::trans)
                .collect(toList());
    }

    public Optional<AttributeValue> readAttributeValue(Integer attributeValueId) {
        return attributeValueRepository.findById(attributeValueId);
    }

    public void updateAttributeValue (int attributeValueId, AttributeValue newAttributeValue) {
        AttributeValue attributeValue = attributeValueRepository.findById(attributeValueId).get();
        attributeValue.setValue(newAttributeValue.getValue());
       attributeValueRepository.save(attributeValue);
    }
    public void deleteAttributeValueyById (int id) {
        attributeValueRepository.deleteById(id);
    }
}
