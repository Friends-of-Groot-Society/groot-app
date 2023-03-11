package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.NftDto;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.models.Nft;
import com.friendsofgroot.app.models.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NftMapper {
    Nft toEntity(NftDto nftDto);

    NftDto toDto(Nft nft);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Nft partialUpdate(NftDto nftDto, @MappingTarget Nft nft);
    
    // custom



}