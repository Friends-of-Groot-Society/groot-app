package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.NftAddressDto;
import com.friendsofgroot.app.models.NftAddress;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NftAddressMapper {
    NftAddress toEntity(NftAddressDto nftAddressDto);

    NftAddressDto toDto(NftAddress nftAddress);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftAddress partialUpdate(NftAddressDto nftAddressDto, @MappingTarget NftAddress nftAddress);
}