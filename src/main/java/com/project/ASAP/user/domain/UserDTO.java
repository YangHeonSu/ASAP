package com.project.ASAP.user.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    // nullable = false 는 필수값을 의미함,  unique = true는 테이블에서 고유값을 의미
    @Column(name = "userId")
    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId="";
    
    @NotBlank(message = "이름을 입력해주세요.")
    @Column(name = "name")
    private String name ="";

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Column(name = "password")
    private String password="";

    @NotBlank(message = "회사명을 입력해주세요.")
    @Column(name = "company_name")
    private String companyName="";

    @NotBlank(message = "부서명을 입력해주세요.")
    @Column(name = "department")
    private String department="";

    private String auth = "";
}
