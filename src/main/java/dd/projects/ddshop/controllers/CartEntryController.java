package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.CartEntryDTO;
import dd.projects.ddshop.entities.*;
import dd.projects.ddshop.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CartEntryController {

    private final CartEntryService cartEntryService;

    @Autowired
    VariantService variantService;

    @Autowired
    CartService cartService;

    @Autowired
    public CartEntryController (CartEntryService cartEntryService) {
        this.cartEntryService = cartEntryService;
    }

    @GetMapping("/getCartEntry")
    public ResponseEntity<List<CartEntryDTO>> getCartEntry() {
        return new ResponseEntity<>(cartEntryService.getCartEntry(), HttpStatus.OK);
    }

    @PostMapping("/createCartEntry")
    public ResponseEntity <Object> createCartEntry (@RequestBody CartEntryDTO cartEntryDTO){
        Variant variant = variantService.readVariant(cartEntryDTO.getVariantId());
        System.out.println(variant);
        Cart cart = cartService.readCart(cartEntryDTO.getCartId());
        System.out.println(cart);
        cartEntryService.createCartEntry(cartEntryDTO,variant,cart);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateCartEntry/{id}")
    public ResponseEntity<Object> updateCartEntry (@PathVariable Integer id, @RequestBody CartEntry newCartEntry) {
        cartEntryService.updateCartEntry(id,newCartEntry);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCartEntryById/{id}")
    void deleteCartEntryById (@PathVariable Integer id) {
        cartEntryService.deleteCartEntryById(id);
    }
}
