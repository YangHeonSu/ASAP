package com.project.ASAP.Login.domain;

import com.project.ASAP.user.domain.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class LoginInfo  {

    private String userId;
    private String password;
    private String auth;

    public LoginInfo(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.password = userDTO.getPassword();
        this.auth = userDTO.getAuth();
    }

}
