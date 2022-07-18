package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.services.CategoryService;
import dd.projects.ddshop.services.ProductService;
import dd.projects.ddshop.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/getSubcategory")
    public ResponseEntity<List<SubcategoryDTO>> getSubcategory() {
        return new ResponseEntity<>(subcategoryService.getSubcategory(), HttpStatus.OK);
    }

    @PostMapping("/createSubcategory")
    public ResponseEntity <Object> createSubcategory (@RequestBody SubcategoryDTO subcategoryDTO){
        Optional<Category> optionalCategory = categoryService.readCategory(subcategoryDTO.getCategoryId());
        Category category = optionalCategory.get();
        subcategoryService.createSubcategory(subcategoryDTO,category);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateSubcategory/{id}")
    public ResponseEntity<Object> updateSubcategory (@PathVariable Integer id, @RequestBody Subcategory newSubcategory) {
        subcategoryService.updateSubcategory(id,newSubcategory);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteSubcategoryById/{id}")
    void deleteSubcategoryById (@PathVariable Integer id) {
        subcategoryService.deleteSubcategoryById(id);
    }
}
