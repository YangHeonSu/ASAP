package com.project.ASAP.user.repository;

import com.project.ASAP.user.domain.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository{

    private final EntityManager entityManager;

    @Override
    public List<UserDTO> findAllUser(UserDTO userDTO) throws Exception {
        // JPA 는 Entity 에서 조회!!
        List<UserDTO> users = entityManager.createQuery("select user from UserDTO user",  UserDTO.class).getResultList();
        return users;
    }

    @Override
    public Optional<UserDTO> findUserById(String id) throws Exception {
        UserDTO user = entityManager.find(UserDTO.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void registerUser(UserDTO userDTO) throws Exception {
        entityManager.persist(userDTO);
    }

    @Override
    @Transactional
    public void modifyUser(UserDTO userDTO) throws Exception {
        UserDTO user = entityManager.find(UserDTO.class, userDTO.getId());
        user.setPassword(userDTO.getPassword());
        user.setCompanyName(userDTO.getCompanyName());
        user.setDepartment(userDTO.getDepartment());
        user.setName(user.getName());
    }

    @Override
    public void deleteUser(String userCode) throws Exception {
        UserDTO user = entityManager.find(UserDTO.class, userCode);
        entityManager.remove(user);
    }


}
