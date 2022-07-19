package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.CartDTO;
import dd.projects.ddshop.dtos.CategoryDTO;
import dd.projects.ddshop.dtos.ProductDTO;
import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.CartMapper;
import dd.projects.ddshop.mappers.CategoryMapper;
import dd.projects.ddshop.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.CartRepository;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService (CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public static Cart getCartFromDTO(CartDTO cartDTO) {
        Cart cart = new Cart(UserMapper.sourceToDestination(cartDTO.getUserId()),cartDTO.getTotalPrice(),cartDTO.getCartEntries());
        return cart;
    }

    public void createCart (CartDTO cartDTO) {
        Cart cart = getCartFromDTO(cartDTO);
        cartRepository.save(cart);
    }

    public void addCart (Cart cart) {
        cartRepository.save(cart);
    }

    public List<CartDTO> getCart() {
        return cartRepository.findAll()
                .stream()
                .map(CartMapper::trans)
                .collect(toList());
    }

    public Cart readCart(Integer cartId) {
        return cartRepository.getReferenceById(cartId);
    }

    public void updateCart (int cartId, Cart newCart) {
        Cart cart = cartRepository.findById(cartId).get();
        cart.setTotalPrice(newCart.getTotalPrice());
        cartRepository.save(cart);
    }
    public void deleteCartById (int id) {
        cartRepository.deleteById(id);
    }
}
