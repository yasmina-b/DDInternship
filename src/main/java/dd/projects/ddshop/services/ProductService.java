package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.ProductMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService{

    private final ProductRepository productRepository;

    private final ProductMapperImpl productMapper;

    @Autowired
    public ProductService (ProductRepository productRepository, ProductMapperImpl productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public static Product getProductFromDTO(ProductDTO productDto, Subcategory subcategory) {
        Product product = new Product(productDto.getName(),productDto.getDescription(),subcategory);
        return product;
    }
    public Product readProduct(Integer productId) {
        return productRepository.getReferenceById(productId);
    }

    public void createProduct (ProductDTO productDto, Subcategory subcategory) {
        Product product = getProductFromDTO(productDto, subcategory);
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
