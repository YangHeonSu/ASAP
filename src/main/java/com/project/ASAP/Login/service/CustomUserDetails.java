package com.project.ASAP.Login.service;

import com.project.ASAP.User.Domain.UserDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Spring Security가 로그인 요청을 가로채 로그인을 진행하고 완료 되면 UserDetail 타입의 Objcet를
 * Spring Security의 고유한 Session 저장소에 저장한다.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "username")
public class CustomUserDetails implements UserDetails {
    private final UserDTO userDTO;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(()-> "ROLE_" + userDTO.getAuth());
        return collection;
    }

    @Override
    public String getPassword() {
        return userDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDTO.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
