package dd.projects.ddshop.services;


import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.AddressRepository;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService (AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public void createAddress (Address address) {
        addressRepository.save(address);
    }
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public void updateAddress (int addressId, Address newAddress) {
        Address address = addressRepository.findById(addressId).get();
        address.setStreetLine(newAddress.getStreetLine());
        address.setPostalCode(newAddress.getPostalCode());
        address.setCity(newAddress.getCity());
        address.setCounty(newAddress.getCounty());
        address.setCountry(newAddress.getCountry());
        addressRepository.save(address);
    }
    public void deleteAddressById (int id) {
        addressRepository.deleteById(id);
    }

}
