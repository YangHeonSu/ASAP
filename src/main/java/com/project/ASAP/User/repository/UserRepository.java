package com.project.ASAP.User.repository;

import com.project.ASAP.User.Domain.User;
import com.project.ASAP.User.Domain.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {

    /**
     * findAll User(모든 사용자 조회)
     * @return List<UserDTO> users
     */
    @Override
    List<User> findAll();

    Optional<User> findByUserId(String userId);

    @Override
    void deleteById(String id);

}
