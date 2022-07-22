package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.AddressDTO;
import dd.projects.ddshop.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {
    AddressDTO toAddressDTO(Address address);

    Address toAddress (AddressDTO addressDTO);

    List<AddressDTO> toAddressDTOList (List<Address> addresses);
}
