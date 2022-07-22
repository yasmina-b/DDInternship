package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.CartEntryDTO;
import dd.projects.ddshop.entities.*;
import dd.projects.ddshop.mappers.CartMapperImpl;
import dd.projects.ddshop.mappers.VariantMapperImpl;
import dd.projects.ddshop.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CartEntryController {

    private final CartEntryService cartEntryService;

    private final VariantService variantService;

    private final CartService cartService;

    private final VariantMapperImpl variantMapper;

    private final CartMapperImpl cartMapper;

    @Autowired
    public CartEntryController (final CartEntryService cartEntryService, final VariantService variantService, final CartService cartService, final VariantMapperImpl variantMapper, final CartMapperImpl cartMapper) {
        this.cartEntryService = cartEntryService;
        this.variantService = variantService;
        this.cartService = cartService;
        this.variantMapper = variantMapper;
        this.cartMapper = cartMapper;
    }

    @GetMapping("/getCartEntry")
    public ResponseEntity<List<CartEntryDTO>> getCartEntry() {
        return new ResponseEntity<>(cartEntryService.getCartEntry(), HttpStatus.OK);
    }

    @PostMapping("/createCartEntry")
    public ResponseEntity <Object> createCartEntry (@RequestBody final CartEntryDTO cartEntryDTO){
        Variant variant = variantService.readVariant(variantMapper.toVariant(cartEntryDTO.getVariantId()).getId());
        Cart cart = cartService.readCart(cartMapper.toCart(cartEntryDTO.getCartId()).getId());
        cartEntryService.createCartEntry(cartEntryDTO,variant,cart);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @PutMapping("/updateCartEntry/{id}")
    public ResponseEntity<Object> updateCartEntry (@PathVariable Integer id, @RequestBody CartEntryDTO newCartEntryDTO) {
        cartEntryService.updateCartEntry(id,newCartEntryDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCartEntryById/{id}")
    void deleteCartEntryById (@PathVariable final Integer id) {
        cartEntryService.deleteCartEntryById(id);
    }
}
