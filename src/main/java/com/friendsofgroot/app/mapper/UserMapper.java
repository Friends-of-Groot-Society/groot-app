package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(source = "userId", target = "id") // int
//    @Mapping(source = "id", target = "userId") // string
//    @Mapping(  target = "username", expression = "java(user.getEmail().truncate(10))")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
//    @Mapping(source = "id", target = "id", expression = "java(UUID.randomUUID().toString())")
    UserDto userToUserDto(User user);

//    @InheritInverseConfiguration
//    User userDtoToUser(UserDto userDto);


    UserDto toDto(User u);

    @Mapping(source = "idToken", target = "id")
    User toEntity(UserDto user);

    List<UserDto> toListDto(List<UserDto> users);

    UserDto toDtoFromOptional(Optional<User> u);
}
