package com.project.ASAP.SpringSecurity;

import com.project.ASAP.Login.service.CustomUserDetails;
import com.project.ASAP.Login.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // @Configuration에 @EnableWebSecurity를 추가해 Spring Security 설정 클래스임을 알려줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailService userDetailService;
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        // 특정 경로에 대해서는 무시
        webSecurity.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/font/**", "/html/**", "/templates/**", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN") //admin으로 시작하는 모든 경로는 ADMIN 권한 사용자만 접근
                .antMatchers("/users/**").permitAll() // 모든 경로에 권한없이 접근 가능
                .antMatchers("/users").permitAll()
                .antMatchers("/log*").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login.do")
                    .usernameParameter("userId")
                    .passwordParameter("password")
                    .loginProcessingUrl("/loginProc.do") // Security 에서 해당 주소로 오는 요청을 낚아채서 수행한다.
                    .defaultSuccessUrl("/dashboard.do", true)// 로그인 성공 시 이동 되는 페이지
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login.do")
                    .invalidateHttpSession(true)
                .and()
                    .exceptionHandling().accessDeniedPage("/login/denied");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
}

