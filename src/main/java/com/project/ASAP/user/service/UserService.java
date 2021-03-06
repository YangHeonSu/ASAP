package com.project.ASAP.user.service;

import com.project.ASAP.user.domain.UserDTO;
import com.project.ASAP.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional  // jpa를 쓰면 반드시 있어야함 데이터를 저장하거나 변경할때 필요
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * load Users
     *
     * @param userDTO userDTO
     * @return List<UserDTO> users
     * @throws Exception the Excetpion
     */
    public List<UserDTO> findAllUser(UserDTO userDTO) throws Exception {
        return userRepository.findAllUser(userDTO);
    }

    /**
     * Find User By Id(=PK)
     *
     * @param id id
     * @return UserDTO user
     * @throws Exception the Exception
     */
    public Optional<UserDTO> findUserById(String id) throws Exception{
        return userRepository.findUserById(id);
    }

    /**
     * Create Users
     *
     * @param userDTO userDTO
     * @throws Exception the Exception
     */
    public void createUser(UserDTO userDTO) throws Exception {
        userRepository.registerUser(userDTO);
    }

    /**
     * Modify Users
     *
     * @param userDTO userDTO
     * @throws Exception the Exception
     */
    public void modifyUser(UserDTO userDTO) throws Exception{
        Optional<UserDTO> user = userRepository.findUserById(userDTO.getId());
        if (user.isPresent()){
            userRepository.modifyUser(userDTO);
        }
    }

    /**
     * Delete Users
     *
     * @param userCode id(=Pk)
     * @throws Exception
     */
    public void deleteUser(String userCode) throws Exception{
        userRepository.deleteUser(userCode);
    }
}
