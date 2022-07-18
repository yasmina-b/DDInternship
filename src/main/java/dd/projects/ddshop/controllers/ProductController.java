package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.SubcategoryDtoMapper;
import dd.projects.ddshop.mappers.SubcategoryMapper;
import dd.projects.ddshop.services.ProductService;
import dd.projects.ddshop.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    SubcategoryService subcategoryService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProduct")
    public ResponseEntity<List<ProductDTO>> getProduct() {
        return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO productDto) {
        Optional<Subcategory> optionalSubcategory = subcategoryService.readSubcategory(SubcategoryDtoMapper.trans(productDto.getSubcategoryId()).getId());
        Subcategory subcategory = optionalSubcategory.get();
        productService.createProduct(productDto, subcategory);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProduct (@PathVariable Integer id, @RequestBody Product newProduct) {
        productService.updateProduct(id,newProduct);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductById/{id}")
    void deleteProductById (@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
