package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(source = "userId", target = "id")
//    @Mapping(source = "email", target = "userName")
//    @Mapping(source = "id", target = "id", expression = "java(UUID.randomUUID().toString())")
    UserDto userToUserDto(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);
}
