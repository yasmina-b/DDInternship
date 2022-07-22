package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.CategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.mappers.CategoryMapperImpl;
import dd.projects.ddshop.repositories.CategoryRepository;
import dd.projects.ddshop.validations.CategoryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class CategoryService{
    private final CategoryRepository categoryRepository;

    private final CategoryMapperImpl categoryMapper;

    private final CategoryValidation categoryValidation;

    @Autowired
    public CategoryService (final CategoryRepository categoryRepository, final CategoryMapperImpl categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.categoryValidation = new CategoryValidation(categoryRepository);
    }

    public void createCategory (final CategoryDTO categoryDTO) {
        categoryValidation.categoryValidation(categoryDTO);
        categoryRepository.save(categoryMapper.toCategory(categoryDTO));
    }

    public List<CategoryDTO> getCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDTO)
                .collect(toList());
    }
    public void updateCategory (int categoryId, CategoryDTO newCategoryDTO) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(newCategoryDTO.getName());
        categoryRepository.save(category);
    }
    public void deleteCategoryById (final int id) {
        categoryRepository.deleteById(id);
    }
}
