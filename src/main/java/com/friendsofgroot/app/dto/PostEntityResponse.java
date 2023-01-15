package com.friendsofgroot.app.dto;


import com.friendsofgroot.app.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntityResponse {
    private List<PostEntityDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

    @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
    public static interface CommentMapper {
        Comment toEntity(CommentDto commentDto);

        CommentDto toDto(Comment comment);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
    }
}
