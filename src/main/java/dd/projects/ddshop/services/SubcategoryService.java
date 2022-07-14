package dd.projects.ddshop.services;

import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public SubcategoryService (SubcategoryRepository subcategoryRepository){
        this.subcategoryRepository = subcategoryRepository;
    }

    public void createSubcategory (Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public Optional<Subcategory> readSubcategory(Integer subcategoryId) {
        return subcategoryRepository.findById(subcategoryId);
    }
    public List<Subcategory> getSubcategory() {
        return subcategoryRepository.findAll();
    }

    public void updateSubcategory (int subcategoryId, Subcategory newSubcategory) {
        Subcategory subcategory = subcategoryRepository.findById(subcategoryId).get();
        subcategory.setName(newSubcategory.getName());
        subcategoryRepository.save(subcategory);
    }
    public void deleteSubcategoryById (int id) {
        subcategoryRepository.deleteById(id);
    }
}
