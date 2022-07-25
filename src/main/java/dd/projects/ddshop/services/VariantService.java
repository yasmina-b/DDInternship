package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.VariantDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Variant;
import dd.projects.ddshop.mappers.VariantMapperImpl;
import dd.projects.ddshop.repositories.ProductRepository;
import dd.projects.ddshop.repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VariantService {

    private final VariantRepository variantRepository;

    private final VariantMapperImpl variantMapper;

    private final ProductRepository productRepository;

    @Autowired
    public VariantService (final VariantRepository variantRepository, final VariantMapperImpl variantMapper, final ProductRepository productRepository){
        this.variantRepository = variantRepository;
        this.variantMapper = variantMapper;
        this.productRepository = productRepository;
    }
    public void createVariant (final VariantDTO variantDTO, final int productId) {
        final Product product = productRepository.getReferenceById(productId);
        Variant variant = variantMapper.toVariant(variantDTO);
        variant.setProductId(product);
        variantRepository.save(variant);
    }

    public List<VariantDTO> getVariant() {
        return variantRepository.findAll()
                .stream()
                .map(variantMapper::toVariantDTO)
                .collect(toList());
    }

    public Variant readVariant(Integer variantId) {
        return variantRepository.getReferenceById(variantId);
    }

    public void updateVariant (int variantId, VariantDTO newVariant) {
        Variant variant = variantRepository.findById(variantId).get();
        variant.setPrice(newVariant.getPrice());
        variant.setAvailableQuantity(newVariant.getAvailableQuantity());
        variantRepository.save(variant);
    }

    public void deleteVariantById (final int id) {
        variantRepository.deleteById(id);
    }
}
