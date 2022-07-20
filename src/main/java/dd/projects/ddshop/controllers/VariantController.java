package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.VariantDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.mappers.ProductMapperImpl;
import dd.projects.ddshop.services.ProductService;
import dd.projects.ddshop.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VariantController {

   private final VariantService variantService;

   private final ProductService productService;

   private final ProductMapperImpl productMapper;

    @Autowired
    public VariantController(VariantService variantService, ProductService productService, ProductMapperImpl productMapper) {
      this.variantService = variantService;
      this.productService = productService;
      this.productMapper = productMapper;
    }

    @GetMapping("/getVariant")
    public ResponseEntity<List<VariantDTO>> getVariant() {
        return new ResponseEntity<>(variantService.getVariant(), HttpStatus.OK);
    }

    @PostMapping("/createVariant")
    public ResponseEntity<Object> addVariant(@RequestBody VariantDTO variantDTO) {
        Product product = productService.readProduct(productMapper.toProduct(variantDTO.getProductId()).getId());
        variantService.createVariant(variantDTO,product);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateVariant/{id}")
    public ResponseEntity<Object> updateVariant (@PathVariable Integer id, @RequestBody VariantDTO newVariant) {
        variantService.updateVariant(id,newVariant);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteVariantById/{id}")
    void deleteVariantById (@PathVariable Integer id) {
        variantService.deleteVariantById(id);
    }
}
