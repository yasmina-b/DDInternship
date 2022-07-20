package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.CartDTO;
import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.mappers.CartMapperImpl;
import dd.projects.ddshop.mappers.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.CartRepository;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CartService {
    private final CartRepository cartRepository;

    private final CartMapperImpl cartMapper;

    private final UserMapperImpl userMapper;

    @Autowired
    public CartService (CartRepository cartRepository, CartMapperImpl cartMapper, UserMapperImpl userMapper){
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.userMapper = userMapper;
    }

//    public static Cart getCartFromDTO(CartDTO cartDTO) {
//        Cart cart = new Cart(userMapper.toUserDTO(cartDTO.getUserId()),cartDTO.getTotalPrice(),cartDTO.getCartEntries());
//        return cart;
//    }
//
//    public void createCart (CartDTO cartDTO) {
//        Cart cart = getCartFromDTO(cartDTO);
//        cartRepository.save(cart);
//    }

    public void addCart (CartDTO cartDTO) { cartRepository.save(cartMapper.toCart(cartDTO));
    }

    public List<CartDTO> getCart() {
        return cartRepository.findAll()
                .stream()
                .map(cartMapper::toCartDTO)
                .collect(toList());
    }

    public Cart readCart(Integer cartId) {
        return cartRepository.getReferenceById(cartId);
    }

    public void updateCart (int cartId, CartDTO newCart) {
        Cart cart = cartRepository.findById(cartId).get();
        cart.setTotalPrice(newCart.getTotalPrice());
        cartRepository.save(cart);
    }
    public void deleteCartById (int id) {
        cartRepository.deleteById(id);
    }
}
