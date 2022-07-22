package dd.projects.ddshop.controllers;

import dd.projects.ddshop.dtos.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dd.projects.ddshop.services.AddressService;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(final AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/getAddress")
    public ResponseEntity<List<AddressDTO>> getAddress() {
        return new ResponseEntity<>(addressService.getAddress(), HttpStatus.OK);
    }
    @PostMapping("/createAddress")
    public ResponseEntity <Object> createAddress(@RequestBody final AddressDTO addressDTO){
        addressService.createAddress(addressDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<Object> updateAddress (@PathVariable Integer id, @RequestBody AddressDTO newAddressDTO) {
        addressService.updateAddress(id,newAddressDTO);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @DeleteMapping("/deleteAddressById/{id}")
    void deleteAddressById (@PathVariable final Integer id) {
        addressService.deleteAddressById(id);
    }


}
