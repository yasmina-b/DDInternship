package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.ProductAttributeMapperImpl;
import dd.projects.ddshop.services.AttributeValueService;
import dd.projects.ddshop.services.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttributeValueController {

    private final AttributeValueService attributeValueService;

    private final ProductAttributeService productAttributeService;

    private final ProductAttributeMapperImpl productAttributeMapper;

    @Autowired
    public AttributeValueController (AttributeValueService attributeValueService, ProductAttributeService productAttributeService, ProductAttributeMapperImpl productAttributeMapper) {
        this.attributeValueService = attributeValueService;
        this.productAttributeService = productAttributeService;
        this.productAttributeMapper = productAttributeMapper;
    }

    @GetMapping("/getAttributeValue")
    public ResponseEntity<List<AttributeValueDTO>> getAttributeValue() {
        return new ResponseEntity<>(attributeValueService.getAttributeValue(), HttpStatus.OK);
    }

    @PostMapping("/createAttributeValue")
    public ResponseEntity <Object> createAttributeValue (@RequestBody AttributeValueDTO attributeValueDTO){
        ProductAttribute productAttribute = productAttributeService.readProductAttribute(productAttributeMapper.toProductAttribute(attributeValueDTO.getProductAttributeId()).getId());
        attributeValueService.createAttributeValue(attributeValueDTO,productAttribute);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateAttributeValue/{id}")
    public ResponseEntity<Object> updateAttributeValue (@PathVariable Integer id, @RequestBody AttributeValueDTO newAttributeValueDTO) {
        attributeValueService.updateAttributeValue(id,newAttributeValueDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteAttributeValueById/{id}")
    void deleteAttributeValueById (@PathVariable Integer id) {
        attributeValueService.deleteAttributeValueById(id);
    }
}
