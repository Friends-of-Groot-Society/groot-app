package com.friendsofgroot.mapllistener.mappers;

import com.friendsofgroot.mapllistener.dto.PostEntityDto;
import com.friendsofgroot.mapllistener.models.PostEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostEntityMapper {
    PostEntity toEntity(PostEntityDto postEntityDto);

    PostEntityDto toDto(PostEntity postEntity);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostEntityDto postEntityDto, @MappingTarget PostEntity postEntity);

    PostEntityDto PostEntityToPostEntityDto(PostEntity postByUsernameAndId);

    List<PostEntity> PostEntitysToPostEntityDtos(List<PostEntity> allPostsByUsername);

    PostEntity PostEntityDtoToPostEntity(PostEntityDto postEntityDto);


//    List<PostEntity> PostEntityDtosToPostEntitys(List<PostEntityDto> postEntityDtos);

}
