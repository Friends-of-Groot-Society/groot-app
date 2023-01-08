package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.dto.CoinDto;
import com.friendsofgroot.app.dto.PostEntityDto;
import com.friendsofgroot.app.models.PostEntity;
import com.friendsofgroot.app.models.Weblink;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostEntityMapper {
    PostEntity toEntity(PostEntityDto postEntityDto);

    PostEntityDto toDto(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostEntityDto postEntityDto, @MappingTarget PostEntity postEntity);

    PostEntityDto PostEntityToPostEntityDTO(PostEntity postByUsernameAndId);

    List<PostEntity> PostEntitysToPostEntityDTOs(List<PostEntity> allPostsByUsername );

    @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
    interface WeblinkMapper {
        Weblink toEntity(CoinDto.WeblinkDto weblinkDto);

        CoinDto.WeblinkDto toDto(Weblink weblink);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        Weblink partialUpdate(CoinDto.WeblinkDto weblinkDto, @MappingTarget Weblink weblink);
    }
}