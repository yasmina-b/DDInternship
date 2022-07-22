package dd.projects.ddshop.services;

import dd.projects.ddshop.dtos.AddressDTO;
import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.mappers.AddressMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dd.projects.ddshop.repositories.AddressRepository;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapperImpl addressMapper;

    @Autowired
    public AddressService (final AddressRepository addressRepository, final AddressMapperImpl addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }
    public void createAddress (final AddressDTO addressDTO) {
        addressRepository.save(addressMapper.toAddress(addressDTO));
    }
    public List<AddressDTO> getAddress() {
        return addressMapper.toAddressDTOList(addressRepository.findAll());
    }
    public void updateAddress (int addressId, AddressDTO newAddressDTO) {
        Address address = addressRepository.findById(addressId).get();
        address.setStreetLine(newAddressDTO.getStreetLine());
        address.setPostalCode(newAddressDTO.getPostalCode());
        address.setCity(newAddressDTO.getCity());
        address.setCounty(newAddressDTO.getCounty());
        address.setCountry(newAddressDTO.getCountry());
        addressRepository.save(address);
    }
    public void deleteAddressById (final int id) {
        addressRepository.deleteById(id);
    }

}
