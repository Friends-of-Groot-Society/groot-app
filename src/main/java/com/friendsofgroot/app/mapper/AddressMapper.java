package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.AddressDto;
import com.friendsofgroot.app.models.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses= {UserMapper.class})
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "id", target = "id")
//    @Mapping(source = "userDto", target = "user")
    Address addressDtoToAddress(AddressDto addressDto);

    @InheritInverseConfiguration
    AddressDto addressToAddressDto(Address address);

}
