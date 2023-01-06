package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userId", target = "id") // int
    @Mapping(source = "id", target = "userId") // string
//    @Mapping(  target = "userName", expression = "java(user.getEmail().truncate(10))")
    @Mapping(source = "lastName", target = "LName")
    @Mapping(source = "firstName", target = "FName")
    @Mapping(source = "userGroup", target = "groupType")
//    @Mapping(source = "id", target = "id", expression = "java(UUID.randomUUID().toString())")
    UserDto userToUserDto(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);

    List<UserDto> usersToUserDtos(List<User> users);
}
