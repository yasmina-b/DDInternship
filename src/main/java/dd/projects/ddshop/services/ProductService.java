package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.ProductMapperImpl;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import dd.projects.ddshop.validations.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class ProductService{

    private final ProductRepository productRepository;

    private final ProductMapperImpl productMapper;

    private final SubcategoryRepository subcategoryRepository;

    private final ProductValidation productValidation;

    @Autowired
    public ProductService (final ProductRepository productRepository, final ProductMapperImpl productMapper, final SubcategoryRepository subcategoryRepository){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.subcategoryRepository = subcategoryRepository;
        this.productValidation = new ProductValidation(productRepository);
    }
    public void createProduct (final ProductDTO productDTO, final int id) {
        productValidation.productValidation(productDTO);
        final Subcategory subcategory = subcategoryRepository.getReferenceById(id);
        final Product product = new Product(productMapper.toProduct(productDTO),subcategory);
        product.setVariant(new ArrayList<>());
        productRepository.save(product);
    }
    public List<ProductDTO> getProduct() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .collect(toList());
    }
    public void updateProduct (int productId, ProductDTO newProductDTO) {
        Product product = productRepository.findById(productId).get();
        product.setName(newProductDTO.getName());
        product.setDescription(newProductDTO.getDescription());
        productRepository.save(product);
    }

    public void deleteProductById (final int id) {
        productRepository.deleteById(id);
    }


}
