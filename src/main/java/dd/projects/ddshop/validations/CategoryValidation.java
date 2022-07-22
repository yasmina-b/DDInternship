package dd.projects.ddshop.validations;

import dd.projects.ddshop.dtos.CategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.exceptions.AlreadyExists;
import dd.projects.ddshop.exceptions.IncorrectInput;
import dd.projects.ddshop.repositories.CategoryRepository;
import dd.projects.ddshop.utils.Util;

public class CategoryValidation {

    private final CategoryRepository categoryRepository;

    public CategoryValidation(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void categoryValidation (final CategoryDTO categoryDTO){
        checkEmptyFields(categoryDTO);
        checkCategoryAlreadyExists(categoryDTO);
    }
    public void checkEmptyFields (final CategoryDTO categoryDTO) {
        if(categoryDTO.getName().isEmpty())
            throw new IncorrectInput(Util.getMessage("api.error.empty.field", null));
    }
    public void checkCategoryAlreadyExists (final CategoryDTO categoryDTO) {
        for(final Category category : categoryRepository.findAll()){
            if(category.getName().equals(categoryDTO.getName()))
                throw new AlreadyExists(Util.getMessage("api.error.category.name",null));
        }
    }
}
