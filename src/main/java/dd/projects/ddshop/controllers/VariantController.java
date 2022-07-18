package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.VariantDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Variant;
import dd.projects.ddshop.services.ProductService;
import dd.projects.ddshop.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VariantController {

   private final VariantService variantService;

    @Autowired
    ProductService productService;

    @Autowired
    public VariantController(VariantService variantService) {
      this.variantService = variantService;
    }

    @GetMapping("/getVariant")
    public ResponseEntity<List<VariantDTO>> getVariant() {
        return new ResponseEntity<>(variantService.getVariant(), HttpStatus.OK);
    }

    @PostMapping("/createVariant")
    public ResponseEntity<Object> addVariant(@RequestBody VariantDTO variantDto) {
        Optional<Product> optionalProduct = productService.readProduct(variantDto.getProductId());
        Product product = optionalProduct.get();
        variantService.createVariant(variantDto,product);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateVariant/{id}")
    public ResponseEntity<Object> updateVariant (@PathVariable Integer id, @RequestBody Variant newVariant) {
        variantService.updateVariant(id,newVariant);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteVariantById/{id}")
    void deleteVariantById (@PathVariable Integer id) {
        variantService.deleteVariantById(id);
    }
}
