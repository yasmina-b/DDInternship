package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.SubcategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.SubcategoryMapperImpl;
import dd.projects.ddshop.repositories.CategoryRepository;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import dd.projects.ddshop.validations.SubcategoryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    private final CategoryRepository categoryRepository;

    private final SubcategoryMapperImpl subcategoryMapper;

    private final SubcategoryValidation subcategoryValidation;

    @Autowired
    public SubcategoryService (final SubcategoryRepository subcategoryRepository, final CategoryRepository categoryRepository, final SubcategoryMapperImpl subcategoryMapper){
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
        this.subcategoryMapper = subcategoryMapper;
        this.subcategoryValidation = new SubcategoryValidation(subcategoryRepository);
    }

    public void createSubcategory (final String name, final int id) {
        subcategoryValidation.subcategoryValidation(name);
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

    public void updateSubcategory (int subcategoryId, SubcategoryDTO newSubcategoryDTO) {
        Subcategory subcategory = subcategoryRepository.findById(subcategoryId).get();
        subcategory.setName(newSubcategoryDTO.getName());
        subcategoryRepository.save(subcategory);
    }
    public void deleteSubcategoryById (final int id) {
        subcategoryRepository.deleteById(id);
    }
}
