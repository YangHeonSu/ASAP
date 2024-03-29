package com.project.ASAP.User.Domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user")
public class UserDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    // nullable = false 는 필수값을 의미함,  unique = true는 테이블에서 고유값을 의미
    @Column(name = "USER_ID")
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z0-9])[a-z0-9]{3,16}$|" , message = "아이디는 4~12 자리 영문(대,소), 숫자만 입력 가능합니다.")
    private String userId="";
    
    @NotBlank(message = "이름을 입력해주세요.")
    @Column(name = "NAME")
    private String name ="";

    @Column(name = "PASSWORD")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{6,12}|",
            message = "비밀번호는 영문자와 숫자, 특수기호가 적어도 1개 이상 포함된 6자~12자의 비밀번호여야 합니다.")
    private String password="";

    @NotBlank(message = "회사명을 입력해주세요.")
    @Column(name = "COMPANY_NAME")
    private String companyName="";

    @NotBlank(message = "부서명을 입력해주세요.")
    @Column(name = "DEPARTMENT_NAME")
    private String department_name="";

    @NotBlank(message = "권한을 선택해주세요.")
    @Column(name = "auth")
    private String auth = "";

    public void bCryptPasswordEncoder(String bCryptPassword) {
        this.password = bCryptPassword;
    }
}
