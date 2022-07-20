package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.CartEntryDTO;
import dd.projects.ddshop.entities.*;
import dd.projects.ddshop.mappers.CartEntryMapperImpl;
import dd.projects.ddshop.repositories.CartEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class CartEntryService {

    private final CartEntryRepository cartEntryRepository;

    private final CartEntryMapperImpl cartEntryMapper;
    @Autowired
    public CartEntryService (CartEntryRepository cartEntryRepository, CartEntryMapperImpl cartEntryMapper){
       this.cartEntryRepository = cartEntryRepository;
       this.cartEntryMapper = cartEntryMapper;
    }

    public static CartEntry getCartEntryFromDTO(CartEntryDTO cartEntryDTO, Variant variant, Cart cart){
        CartEntry cartEntry = new CartEntry();
        cartEntry.setQuantity(cartEntryDTO.getQuantity());
        cartEntry.setPricePerPiece(cartEntryDTO.getPricePerPiece());
        cartEntry.setTotalPricePerEntry(cartEntryDTO.getTotalPricePerEntry());
        cartEntry.setVariantId(variant);
        cartEntry.setCartId(cart);
        return cartEntry;

    }
    public void createCartEntry (CartEntryDTO cartEntryDTO,Variant variant, Cart cart) {
        CartEntry cartEntry = getCartEntryFromDTO(cartEntryDTO,variant,cart);
        cartEntryRepository.save(cartEntry);
    }

    public List<CartEntryDTO> getCartEntry() {
        return cartEntryRepository.findAll()
                .stream()
                .map(cartEntryMapper::toCartEntryDTO)
                .collect(toList());
    }
    public void updateCartEntry (int cartEntryId, CartEntryDTO newCartEntryDTO) {
        CartEntry cartEntry = cartEntryRepository.findById(cartEntryId).get();
        cartEntry.setQuantity(newCartEntryDTO.getQuantity());
        cartEntry.setPricePerPiece(newCartEntryDTO.getPricePerPiece());
        cartEntry.setTotalPricePerEntry(newCartEntryDTO.getTotalPricePerEntry());
        cartEntryRepository.save(cartEntry);
    }
    public void deleteCartEntryById (int id) {
        cartEntryRepository.deleteById(id);
    }


}
