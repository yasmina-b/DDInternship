package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.AttributeValueDTO;
import dd.projects.ddshop.services.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AttributeValueController {

    private final AttributeValueService attributeValueService;

    @Autowired
    public AttributeValueController (final AttributeValueService attributeValueService) {
        this.attributeValueService = attributeValueService;
    }
    @GetMapping("/getAttributeValue")
    public ResponseEntity<List<AttributeValueDTO>> getAttributeValue() {
        return new ResponseEntity<>(attributeValueService.getAttributeValue(), HttpStatus.OK);
    }
    @PostMapping("/createAttributeValue/{id}")
    public ResponseEntity <Object> createAttributeValue (@RequestBody final AttributeValueDTO attributeValueDTO, @PathVariable final int id){
        attributeValueService.createAttributeValue(attributeValueDTO,id);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
    @PutMapping("/updateAttributeValue/{id}")
    public ResponseEntity<Object> updateAttributeValue (@PathVariable Integer id, @RequestBody AttributeValueDTO newAttributeValueDTO) {
        attributeValueService.updateAttributeValue(id,newAttributeValueDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @DeleteMapping("/deleteAttributeValueById/{id}")
    void deleteAttributeValueById (@PathVariable final Integer id) {
        attributeValueService.deleteAttributeValueById(id);
    }
}
