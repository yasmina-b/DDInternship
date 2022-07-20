package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.CategoryMapperImpl;
import dd.projects.ddshop.services.ProductService;
import dd.projects.ddshop.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    private final SubcategoryService subcategoryService;
    private final CategoryMapperImpl categoryMapper;

    @Autowired
    public ProductController(ProductService productService, SubcategoryService subcategoryService, CategoryMapperImpl categoryMapper) {
        this.productService = productService;
        this.subcategoryService = subcategoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/getProduct")
    public ResponseEntity<List<ProductDTO>> getProduct() {
        return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO productDto) {
        Subcategory subcategory = subcategoryService.readSubcategory(categoryMapper.toCategory(productDto.getSubcategoryId().getCategoryId()).getId());
        productService.createProduct(productDto, subcategory);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProduct (@PathVariable Integer id, @RequestBody ProductDTO newProductDTO) {
        productService.updateProduct(id,newProductDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductById/{id}")
    void deleteProductById (@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
