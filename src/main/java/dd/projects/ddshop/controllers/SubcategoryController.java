package dd.projects.ddshop.controllers;

import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/getSubcategory")
    public ResponseEntity<List<Subcategory>> getSubcategory() {
        return new ResponseEntity<>(subcategoryService.getSubcategory(), HttpStatus.OK);
    }

    @PostMapping("/createSubcategory")
    public ResponseEntity <Object> createSubcategory (@RequestBody Subcategory subcategory){
        subcategoryService.createSubcategory(subcategory);
        return new ResponseEntity<>("",HttpStatus.OK);
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
