package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.CategoryDTO;
import dd.projects.ddshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryDTO>> getCategory() {
        return new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity <Object> createCategory (@RequestBody CategoryDTO categoryDTO){
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Object> updateCategory (@PathVariable Integer id, @RequestBody CategoryDTO newCategoryDTO) {
        categoryService.updateCategory(id,newCategoryDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCategoryById/{id}")
    void deleteCategoryById (@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
    }
}
