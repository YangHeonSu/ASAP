package com.project.ASAP.user.service;

import com.project.ASAP.user.domain.UserDTO;
import com.project.ASAP.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.List;
import java.util.Optional;

@Service
@Transactional  // jpa를 쓰면 반드시 있어야함 데이터를 저장하거나 변경할때 필요
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * find Users
     * @return List<UserDTO> users
     * @throws Exception the Excetpion
     */
    public List<UserDTO> findAll() throws Exception {
        return userRepository.findAll();
    }

    /**
     * Find User By Id(=PK)
     * @param id id
     * @return UserDTO user
     * @throws Exception the Exception
     */
    public Optional<UserDTO> findById(String id) throws Exception{
        return userRepository.findById(id);
    }

    /**
     * save user (계정 등록, 수정)
     * @param userDTO userDTO
     * @throws Exception the Exception
     */
    public void save(UserDTO userDTO) throws Exception {
        if (StringUtils.isEmpty(userDTO.getId())) {
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword())); // 비빌번호 해쉬 암호화
            userRepository.save(userDTO);
        } else{
            Optional<UserDTO> user = userRepository.findById(userDTO.getId());
            if (user.isPresent()){
                UserDTO userInfo  = user.get();
                userInfo.setName(userDTO.getName());
                userInfo.setAuth(userDTO.getAuth());
                userInfo.setCompanyName(userDTO.getCompanyName());
                userInfo.setDepartment_name(userDTO.getDepartment_name());
                userRepository.save(userInfo);
            }
        }
    }

    /**
     * Delete User
     * @param id String id (= pk)
     * @throws Exception the Exception
     */
    public void deleteUser(String id) throws Exception {
        userRepository.deleteById(id);
    }


}
