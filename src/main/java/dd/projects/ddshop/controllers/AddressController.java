package dd.projects.ddshop.controllers;

import dd.projects.ddshop.entities.Address;
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
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/getAddress")
    public ResponseEntity<List<Address>> getAddress() {
        return new ResponseEntity<>(addressService.getAddress(), HttpStatus.OK);
    }

    @PostMapping("/createAddress")
    public ResponseEntity <Object> createAddress(@RequestBody Address address){
        addressService.createAddress(address);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<Object> updateAddress (@PathVariable Integer id, @RequestBody Address newAddress) {
        addressService.updateAddress(id,newAddress);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddressById/{id}")
    void deleteAddressById (@PathVariable Integer id) {
        addressService.deleteAddressById(id);
    }


}
