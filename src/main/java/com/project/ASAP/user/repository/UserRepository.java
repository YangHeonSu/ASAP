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

    @Override
    Optional<UserDTO> findById(String id);

    Optional<UserDTO> findByUserId(String userId);

    @Override
    void deleteById(String id);

}
