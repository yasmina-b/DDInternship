package dd.projects.ddshop.validations;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.exceptions.AlreadyExists;
import dd.projects.ddshop.exceptions.IncorrectInput;
import dd.projects.ddshop.repositories.ProductRepository;
import dd.projects.ddshop.utils.Util;

public class ProductValidation {

    private final ProductRepository productRepository;

    public ProductValidation(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void productValidation(final ProductDTO productDTO) {
        checkEmptyFields(productDTO);
        checkProductAlreadyExist(productDTO);
    }

    public void checkEmptyFields(final ProductDTO productDTO) {
        if(productDTO.getName().isEmpty() || productDTO.getDescription().isEmpty())
            throw new IncorrectInput(Util.getMessage("api.error.empty.field", null));
    }

    public void checkProductAlreadyExist(final ProductDTO productDTO) {
        for(final Product product : productRepository.findAll()){
            if(product.getName().equals(productDTO.getName()))
                throw new AlreadyExists(Util.getMessage("api.error.product.name",null));
        }

    }

}
