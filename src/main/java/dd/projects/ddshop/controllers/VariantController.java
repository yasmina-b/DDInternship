package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.VariantDTO;
import dd.projects.ddshop.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VariantController {

   private final VariantService variantService;
    @Autowired
    public VariantController(final VariantService variantService) {
      this.variantService = variantService;
    }
    @GetMapping("/getVariant")
    public ResponseEntity<List<VariantDTO>> getVariant() {
        return new ResponseEntity<>(variantService.getVariant(), HttpStatus.OK);
    }
    @PostMapping("/createVariant/{id}")
    public ResponseEntity<Object> createVariant(@RequestBody final VariantDTO variantDTO, @PathVariable final int id) {
        variantService.createVariant(variantDTO,id);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
    @PutMapping("/updateVariant/{id}")
    public ResponseEntity<Object> updateVariant (@PathVariable Integer id, @RequestBody VariantDTO newVariant) {
        variantService.updateVariant(id,newVariant);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @DeleteMapping("/deleteVariantById/{id}")
    void deleteVariantById (@PathVariable final Integer id) {
        variantService.deleteVariantById(id);
    }
}
