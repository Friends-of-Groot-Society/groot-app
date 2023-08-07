package com.friendsofgroot.app.models;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NftAddressMapper {
    NftAddress toEntity(NftAddressDto nftAddressDto);

    NftAddressDto toDto(NftAddress nftAddress);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftAddress partialUpdate(NftAddressDto nftAddressDto, @MappingTarget NftAddress nftAddress);
}
