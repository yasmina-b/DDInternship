package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getProduct")
    public ResponseEntity<List<ProductDTO>> getProduct() {
        return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
    }
    @PostMapping("/createProduct/{id}")
    public ResponseEntity<Object> createProduct(@RequestBody final ProductDTO productDto, @PathVariable final int id) {
        productService.createProduct(productDto,id);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProduct (@PathVariable Integer id, @RequestBody ProductDTO newProductDTO) {
        productService.updateProduct(id,newProductDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @DeleteMapping("/deleteProductById/{id}")
    void deleteProductById (@PathVariable final Integer id) {
        productService.deleteProductById(id);
    }
}
