package com.project.ASAP.user.controller;

import com.project.ASAP.user.domain.UserDTO;
import com.project.ASAP.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    /**
     * findAll Users ( 계정 목록 조회)
     * @return List<UserDTO> users
     * @throws Exception the Exception
     */
    @GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public List<UserDTO> findAll() throws Exception {
        return userService.findAll();
    }

    /**
     * Save User
     * @param userDTO userDTO
     * @return User
     * @throws Exception the Exception
     */
    @PostMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public Map<String, Object> saveUser(@Validated @RequestBody UserDTO userDTO, BindingResult bindingResult) throws Exception {
        Map<String, Object> createResult = new HashMap<>();
        
        if (bindingResult.hasErrors()) {   // 파라미터(UserDTO 등록 폼에서의 입력값)에 대한 유효성 검사 메세지가 있는 경우
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError error : allErrors) {
                createResult.put(error.getField(), error.getDefaultMessage());
            }
        } else {
            userService.save(userDTO);
            createResult.put("saveResult", 200);
        }
        return createResult;
    }

    /* Delete User
     * @param id id (=PK)
     * @return
     * @throws Exception the Exception
     */
    @DeleteMapping(value = "/users/{id}", produces = "application/json; charset=UTF-8")
    public Map<String, Object> deleteUser(@PathVariable String id) throws Exception {
        Map<String, Object> deleteResult = new HashMap<>();

        userService.deleteUser(id);
        deleteResult.put("deleteResult", 200);

        return deleteResult;
    }
}
