package com.project.ASAP.Login.domain;

import com.project.ASAP.User.Domain.UserDTO;
import lombok.Getter;
import lombok.Setter;

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
