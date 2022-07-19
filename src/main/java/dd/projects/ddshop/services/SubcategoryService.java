package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.SubcategoryMapper;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public SubcategoryService (SubcategoryRepository subcategoryRepository){
        this.subcategoryRepository = subcategoryRepository;
    }

    public static Subcategory getSubcategoryFromDTO(SubcategoryDTO subcategoryDTO, Category category){
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryDTO.getName());
        subcategory.setCategoryId(category);
        subcategory.setProducts(new ArrayList<>());
        subcategory.setProductAttributes(new ArrayList<>());
        return subcategory;

    }

    public void createSubcategory (SubcategoryDTO subcategoryDTO, Category category) {
        Subcategory subcategory = getSubcategoryFromDTO(subcategoryDTO, category);
        subcategoryRepository.save(subcategory);
    }

    public List<SubcategoryDTO> getSubcategory() {
        return subcategoryRepository.findAll()
                .stream()
                .map(SubcategoryMapper::trans)
                .collect(toList());
    }

    public Subcategory readSubcategory(Integer subcategoryId) {
        return subcategoryRepository.getReferenceById(subcategoryId);
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
