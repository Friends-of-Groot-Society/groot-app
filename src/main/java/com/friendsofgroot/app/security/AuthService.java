package com.friendsofgroot.app.security;

import com.friendsofgroot.app.dto.LoginDto;
import com.friendsofgroot.app.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
