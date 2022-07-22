package dd.projects.ddshop.validations;

import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.exceptions.AlreadyExists;
import dd.projects.ddshop.exceptions.IncorrectInput;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import dd.projects.ddshop.utils.Util;

public class SubcategoryValidation {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryValidation(final SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public void subcategoryValidation (final String name) {
        checkEmptyFields(name);
        checkSubcategoryAlreadyExists(name);
    }
    public void checkEmptyFields (final String name) {
        if(name.isEmpty())
            throw new IncorrectInput(Util.getMessage("api.error.empty.field", null));
    }
    public void checkSubcategoryAlreadyExists (final String name) {
        for(final Subcategory subcategory : subcategoryRepository.findAll()){
            if(subcategory.getName().equals(name))
                throw new AlreadyExists(Util.getMessage("api.error.subcategory.name",null));
        }
    }
}
