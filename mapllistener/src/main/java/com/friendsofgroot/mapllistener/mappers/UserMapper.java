package com.friendsofgroot.mapllistener.mappers;

import com.friendsofgroot.mapllistener.dto.UserDto;
import com.friendsofgroot.mapllistener.models.BaseModel;
import com.friendsofgroot.mapllistener.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper   {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    UserDto toDto(User u);

//    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);

    User toEntity(UserDto user);

    List<UserDto> toListDto(List<UserDto> users);

    UserDto toDtoFromOptional(Optional<User> u);

}
