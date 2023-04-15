package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.Attribute;
import com.friendsofgroot.app.dto.AttributeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttributeMapper {
    Attribute toEntity(AttributeDto attributeDto);

    AttributeDto toDto(Attribute attribute);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Attribute partialUpdate(AttributeDto attributeDto, @MappingTarget Attribute attribute);
}