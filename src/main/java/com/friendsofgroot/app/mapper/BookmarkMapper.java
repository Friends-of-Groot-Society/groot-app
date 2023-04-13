package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.BookmarkDto;
import com.friendsofgroot.app.models.Bookmark;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookmarkMapper {
    Bookmark toEntity(BookmarkDto bookmarkDto);

    BookmarkDto toDto(Bookmark bookmark);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bookmark partialUpdate(BookmarkDto bookmarkDto, @MappingTarget Bookmark bookmark);
}