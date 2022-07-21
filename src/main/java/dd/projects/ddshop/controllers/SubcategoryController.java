package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.SubcategoryDTO;
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
    public ResponseEntity<List<SubcategoryDTO>> getSubcategory() {
        return new ResponseEntity<>(subcategoryService.getSubcategory(), HttpStatus.OK);
    }

    @PostMapping("/createSubcategory/{id}")
    public ResponseEntity <String> createSubcategory (@RequestBody SubcategoryDTO subcategoryDTO, @PathVariable int id){
        subcategoryService.createSubcategory(subcategoryDTO.getName(),id);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateSubcategory/{id}")
    public ResponseEntity<Object> updateSubcategory (@PathVariable Integer id, @RequestBody SubcategoryDTO newSubcategoryDTO) {
        subcategoryService.updateSubcategory(id,newSubcategoryDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteSubcategoryById/{id}")
    void deleteSubcategoryById (@PathVariable Integer id) {
        subcategoryService.deleteSubcategoryById(id);
    }
}
