package com.friendsofgroot.app.service;

import com.friendsofgroot.app.repositories.UserRepository;
import com.friendsofgroot.app.mappers.UserMapper;
import com.friendsofgroot.app.models.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
*
 */
@Service
@Primary
@RequiredArgsConstructor
public class UserServiceJPA implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<UserDto> getUserById(UUID uuid) {
        return Optional.ofNullable(userMapper
                .toDto(userRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto saveNewUser(UserDto user) {
        return userMapper.toDto(userRepository
                .save(userMapper.toEntity(user)));
    }

    @Override
    public Optional<UserDto> updateUserById(UUID userId, UserDto user) {
        AtomicReference<Optional<UserDto>> atomicReference = new AtomicReference<>();

        userRepository.findById(userId).ifPresentOrElse(foundUser -> {
            foundUser.setName(user.getName());
            atomicReference.set(Optional.of(userMapper
                    .toDto(userRepository.save(foundUser))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public Boolean deleteUserById(UUID userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<UserDto> patchUserById(UUID userId, UserDto user) {
        AtomicReference<Optional<UserDto>> atomicReference = new AtomicReference<>();

        userRepository.findById(userId).ifPresentOrElse(foundUser -> {
            if (StringUtils.hasText(user.getName())){
                foundUser.setName(user.getName());
            }
            atomicReference.set(Optional.of(userMapper
                    .toDto(userRepository.save(foundUser))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
}
