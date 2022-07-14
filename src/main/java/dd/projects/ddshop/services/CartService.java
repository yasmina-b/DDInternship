package dd.projects.ddshop.services;

import dd.projects.ddshop.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.CartRepository;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService (CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void createCart (Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getCart() {
        return cartRepository.findAll();
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
