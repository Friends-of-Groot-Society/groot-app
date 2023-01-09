package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.WeblinkDto;
import com.friendsofgroot.app.models.Weblink;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WeblinkMapper {
    Weblink toEntity(WeblinkDto weblinkDto);

    WeblinkDto toDto(Weblink weblink);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Weblink partialUpdate(WeblinkDto weblinkDto, @MappingTarget Weblink weblink);
}