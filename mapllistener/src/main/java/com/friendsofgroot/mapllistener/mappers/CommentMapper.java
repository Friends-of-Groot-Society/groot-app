package com.friendsofgroot.mapllistener.mappers;

import com.friendsofgroot.mapllistener.models.Comment;
import com.friendsofgroot.mapllistener.dto.CommentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentMapper {
    Comment toEntity(CommentDto commentDto);

    CommentDto toDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
}