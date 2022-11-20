package com.project.ASAP.user.repository;

import com.project.ASAP.user.domain.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserDTO, String> {

    /**
     * findAll User(모든 사용자 조회)
     * @return List<UserDTO> users
     */
    @Override
    List<UserDTO> findAll();

    Optional<UserDTO> findByUserId(String userId);


    /*    *//**
     * Register User
     *
     * @param userDTO userDTO
     * @throws Exception the Exception
     *//*
    public void registerUser(UserDTO userDTO) throws Exception;

    *//**
     * Find User Info By Id(Pk)
     * @param id (pk Id)
     *
     * @return UserDTO user
     * @throws Exception the Exception
     *//*
    public Optional<UserDTO> findUserById(String id) throws Exception;



    *//**
     * Modify User By Id( == PK)
     *
     * @param userDTO  userDTO
     * @return  Optional<UserDTO> modifyUsers
     * @throws Exception the Exception
     *//*
    public void modifyUser(UserDTO userDTO) throws Exception;

    *//**
     * Delete User
     *
     * @param userCode userCode (= PK)
     * @throws Exception the Exception
     *//*
    public void deleteUser(String userCode) throws Exception;*/
}
