package com.example.user.service;

import com.example.user.domain.entity.User;
import com.example.user.domain.entity.UserRepository;
import com.example.user.domain.response.SignInResponse;
import com.example.user.global.dto.UserDto;
import com.example.user.global.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {
    private final UserRepository userRepository;
    private final TokenService tokenService;



    private final JwtUtil jwtUtil;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    @Override
    public SignInResponse insertUser(String token) {
        UserDto userInfoFromToken = tokenService.getUserInfoFromToken(token);

        boolean existsById = userRepository.existsById(UUID.fromString(userInfoFromToken.id()));
        if(!existsById) userRepository.save(new User().toEntity(userInfoFromToken));
        String generatedToken = jwtUtil.generateToken(userInfoFromToken);
        return SignInResponse.from(generatedToken);
    }

}
