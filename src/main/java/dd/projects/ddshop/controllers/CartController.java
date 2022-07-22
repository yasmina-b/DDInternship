package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.CartDTO;
import dd.projects.ddshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(final CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/getCart")
    public ResponseEntity<List<CartDTO>> getCart() {
        return new ResponseEntity<>(cartService.getCart(), HttpStatus.OK);
    }

    @PostMapping("/createCart")
    public ResponseEntity <Object> createCart(@RequestBody final CartDTO cartDTO){
        cartService.addCart(cartDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateCart/{id}")
    public ResponseEntity<Object> updateCart (@PathVariable Integer id, @RequestBody CartDTO newCartDTO) {
        cartService.updateCart(id,newCartDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCartById/{id}")
    void deleteCartById (@PathVariable final Integer id) {
        cartService.deleteCartById(id);
    }
}
