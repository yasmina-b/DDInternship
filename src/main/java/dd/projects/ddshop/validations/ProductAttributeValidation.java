package dd.projects.ddshop.validations;

import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.exceptions.AlreadyExists;
import dd.projects.ddshop.exceptions.IncorrectInput;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import dd.projects.ddshop.utils.Util;

public class ProductAttributeValidation {

    private final ProductAttributeRepository productAttributeRepository;

    public ProductAttributeValidation(final ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    public void productAttributeValidation (final ProductAttributeDTO productAttributeDTO){
        checkEmptyFields(productAttributeDTO);
        checkProductAttributeAlreadyExists(productAttributeDTO);
    }

    public void checkEmptyFields (final ProductAttributeDTO productAttributeDTO) {
        if(productAttributeDTO.getName().isEmpty())
            throw new IncorrectInput(Util.getMessage("api.error.empty.field", null));
    }
    public void checkProductAttributeAlreadyExists (final ProductAttributeDTO productAttributeDTO) {
        for(final ProductAttribute productAttribute : productAttributeRepository.findAll()){
            if(productAttribute.getName().equals(productAttributeDTO.getName()))
                throw new AlreadyExists(Util.getMessage("api.error.productAttribute.name",null));
        }
    }
}
