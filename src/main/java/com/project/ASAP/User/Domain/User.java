package com.project.ASAP.User.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // nullable = false 는 필수값을 의미함,  unique = true는 테이블에서 고유값을 의미
    @Column(name = "USER_ID")
    private String userId="";

    @NotBlank(message = "이름을 입력해주세요.")
    @Column(name = "NAME")
    private String name ="";

    @Column(name = "PASSWORD")
    private String password="";

    @Column(name = "COMPANY_NAME")
    private String companyName="";

    @Column(name = "DEPARTMENT_NAME")
    private String department_name="";

    @Column(name = "auth")
    private String auth = "";
}
