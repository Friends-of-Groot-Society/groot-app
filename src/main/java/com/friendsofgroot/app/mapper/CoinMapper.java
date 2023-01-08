package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.CoinDto;
import com.friendsofgroot.app.models.Coin;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CoinMapper {
    Coin toEntity(CoinDto coinDto);

    CoinDto toDto(Coin coin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Coin partialUpdate(CoinDto coinDto, @MappingTarget Coin coin);
}