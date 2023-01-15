package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.models.Chain;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChainMapper {
    Chain toEntity(ChainDto chainDto);
    ChainDto toOneDto( Chain chain);
//    ChainDto toDto(List<Chain> chain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chain partialUpdate(ChainDto chainDto, @MappingTarget Chain chain);
}