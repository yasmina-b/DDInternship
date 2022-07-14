package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.ProductRepository;

import java.util.List;
@Service
public class ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public static Product getProductFromDTO(ProductDTO productDto, Subcategory subcategory) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setSubcategoryId(subcategory);
        return product;
    }

    public void createProduct (ProductDTO productDto, Subcategory subcategory) {
        Product product = getProductFromDTO(productDto, subcategory);
        productRepository.save(product);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void updateProduct (int productId, Product newProduct) {
        Product product = productRepository.findById(productId).get();
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        productRepository.save(product);
    }

    public void deleteProductById (int id) {
        productRepository.deleteById(id);
    }


}
