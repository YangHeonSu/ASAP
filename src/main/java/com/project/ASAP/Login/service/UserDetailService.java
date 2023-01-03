package com.project.ASAP.Login.service;

import com.project.ASAP.Login.domain.LoginInfo;
import com.project.ASAP.User.Domain.User;
import com.project.ASAP.User.Domain.UserDTO;
import com.project.ASAP.User.UserMapper;
import com.project.ASAP.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component // ?
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final HttpSession session;

    /**
     * 로그인 시 입력한 userId가 DB에 있는지 확인
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(username).orElseThrow(()->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));
        UserDTO userInfo = UserMapper.INSTANCE.toDto(user);
        session.setAttribute("user", new LoginInfo(userInfo)); // Security 세션에 유저 정보 저장
        return new CustomUserDetails(userInfo);
    }
}
