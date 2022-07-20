package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.services.AddressService;
import dd.projects.ddshop.services.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductAttributeController {

    private final ProductAttributeService productAttributeService;

    @Autowired
    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }
    @GetMapping("/getProductAttribute")
    public ResponseEntity<List<ProductAttributeDTO>> getProductAttribute() {
        return new ResponseEntity<>(productAttributeService.getProductAttribute(), HttpStatus.OK);
    }

    @PostMapping("/createProductAttribute")
    public ResponseEntity <Object> createProductAttribute(@RequestBody ProductAttributeDTO productAttributeDTO){
        productAttributeService.createProductAttribute(productAttributeDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateProductAttribute/{id}")
    public ResponseEntity<Object> updateProductAttribute (@PathVariable Integer id, @RequestBody ProductAttributeDTO newProductAttributeDTO) {
       productAttributeService.updateProductAttribute(id,newProductAttributeDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductAttributeById/{id}")
    void deleteProductAttributeById (@PathVariable Integer id){ productAttributeService.deleteProductAttributeById(id);
    }
}

