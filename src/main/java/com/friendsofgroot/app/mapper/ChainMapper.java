package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.models.Chain;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChainMapper {
    Chain toEntity(ChainDto chainDto);

    ChainDto toDto(Chain chain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chain partialUpdate(ChainDto chainDto, @MappingTarget Chain chain);
}