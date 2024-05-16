package com.example.member.global.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class UserDto implements UserDetails{

    private final String id;
    private final String email;
    private final String nickname;
    private final String birthDay;
    private final String gender;

    public static UserDto from(Map res){
        return new UserDto(
                res.get("id").toString(),
                res.get("email").toString(),
                res.get("nickname").toString(),
                res.get("birthDay").toString(),
                res.get("gender").toString()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
