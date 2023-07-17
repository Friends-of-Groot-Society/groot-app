package com.friendsofgroot.app.config.security;

import com.friendsofgroot.app.models.dto.LoginDto;
import com.friendsofgroot.app.models.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
