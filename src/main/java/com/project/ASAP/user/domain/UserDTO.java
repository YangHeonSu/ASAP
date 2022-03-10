package com.project.ASAP.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // nullable = false 는 필수값을 의미함,  unique = true는 테이블에서 고유값을 의미
    @Column(name = "userId")
    private String userId="";
    @Column(name = "name")
    private String name ="";
    @Column(name = "password")
    private String password ="";
    @Column(name = "company_name")
    private String companyName="";
    @Column(name = "department")
    private String department="";
}
