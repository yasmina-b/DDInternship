package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.SubcategoryMapperImpl;
import dd.projects.ddshop.repositories.CategoryRepository;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    private final CategoryRepository categoryRepository;

    private final SubcategoryMapperImpl subcategoryMapper;

    @Autowired
    public SubcategoryService (SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository, SubcategoryMapperImpl subcategoryMapper){
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

//    public static Subcategory getSubcategoryFromDTO(SubcategoryDTO subcategoryDTO, Category category){
//        Subcategory subcategory = new Subcategory();
//        subcategory.setName(subcategoryDTO.getName());
//        subcategory.setCategoryId(category);
//        subcategory.setProducts(new ArrayList<>());
//        subcategory.setProductAttributes(new ArrayList<>());
//        return subcategory;
//
//    }

    public void createSubcategory (final String name, final int id) {
        final Category category = categoryRepository.getReferenceById(id);
        final Subcategory subcategory = new Subcategory(name,category);
        subcategoryRepository.save(subcategory);
    }

    public List<SubcategoryDTO> getSubcategory() {
        return subcategoryRepository.findAll()
                .stream()
                .map(subcategoryMapper::toSubcategoryDTO)
                .collect(toList());
    }

    public Subcategory readSubcategory(Integer subcategoryId) {
        return subcategoryRepository.getReferenceById(subcategoryId);
    }

    public void updateSubcategory (int subcategoryId, SubcategoryDTO newSubcategoryDTO) {
        Subcategory subcategory = subcategoryRepository.findById(subcategoryId).get();
        subcategory.setName(newSubcategoryDTO.getName());
        subcategoryRepository.save(subcategory);
    }
    public void deleteSubcategoryById (int id) {
        subcategoryRepository.deleteById(id);
    }
}
