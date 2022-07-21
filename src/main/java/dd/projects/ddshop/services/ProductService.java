package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.ProductMapperImpl;
import dd.projects.ddshop.repositories.SubcategoryRepository;
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

    @Autowired
    public ProductService (final ProductRepository productRepository, ProductMapperImpl productMapper, SubcategoryRepository subcategoryRepository){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.subcategoryRepository = subcategoryRepository;
    }
    public void createProduct (final ProductDTO productDto, final int id) {
        final Subcategory subcategory = subcategoryRepository.getReferenceById(id);
        final Product product = new Product(productMapper.toProduct(productDto),subcategory);
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

    public void deleteProductById (int id) {
        productRepository.deleteById(id);
    }


}
