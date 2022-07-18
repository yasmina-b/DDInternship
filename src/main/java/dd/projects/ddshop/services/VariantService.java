package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.dtos.VariantDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.entities.Variant;
import dd.projects.ddshop.repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VariantService {

    private final VariantRepository variantRepository;

    @Autowired
    public VariantService (VariantRepository variantRepository){
        this.variantRepository = variantRepository;
    }

    public static Variant getVariantFromDTO(VariantDTO variantDTO, Product product){
        Variant variant = new Variant();
        variant.setPrice(variantDTO.getPrice());
        variant.setAvailableQuantity(variantDTO.getAvailableQuantity());
        variant.setAddedDate(variantDTO.getAddedDate());
        variant.setProductId(product);
        return variant;
    }

    public void createVariant (VariantDTO variantDTO, Product product) {
        Variant variant = getVariantFromDTO(variantDTO, product);
        variantRepository.save(variant);
    }

    public List<VariantDTO> getVariant() {
        List<Variant> variants = variantRepository.findAll();
        List<VariantDTO> variantsDtos = new ArrayList<>();

        for(Variant variant : variants) {
            variantsDtos.add(new VariantDTO(variant));
        }
        return variantsDtos;
    }

    public void updateVariant (int variantId, Variant newVariant) {
        Variant variant = variantRepository.findById(variantId).get();
        variant.setPrice(newVariant.getPrice());
        variant.setAvailableQuantity(newVariant.getAvailableQuantity());
        variantRepository.save(variant);
    }

    public void deleteVariantById (int id) {
        variantRepository.deleteById(id);
    }
}
