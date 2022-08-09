package com.project.ASAP.user.controller;

import com.project.ASAP.user.domain.UserDTO;
import com.project.ASAP.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
     *
     * @return List<UserDTO> users
     * @throws Exception the Exception
     */
    @GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public List<UserDTO> findAll() throws Exception {
        List<UserDTO> users = userService.findAll();
        return users;
    }

    /**
     * Create User
     *
     * @param userDTO userDTO
     * @return User
     * @throws Exception the Exception
     */
    @PostMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDTO userDTO) throws Exception {
        Map<String, Object> createResult = new HashMap<>();

        userService.save(userDTO);
        createResult.put("createResult", 200);
        return ResponseEntity.ok(createResult);
    }

/*    *//**
     * Modify User
     *
     * @param id      id (= PK)
     * @param userDTO userDTO
     * @return User
     * @throws Exception the Exception
     *//*
    @PutMapping(value = "/users/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Map<String, Object>> modifyUser(@PathVariable String id, @RequestBody UserDTO userDTO) throws Exception {
        Map<String, Object> modifyResult = new HashMap<>();
        userService.modifyUser(userDTO);
        modifyResult.put("modifyResult", 200);
        return ResponseEntity.ok(modifyResult);
    }

    *//**
     * Delete User
     *
     * @param id id (=PK)
     * @return
     * @throws Exception the Exception
     *//*
    @DeleteMapping(value = "/users/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable String id) throws Exception {
        Map<String, Object> deleteResult = new HashMap<>();
        userService.deleteUser(id);
        deleteResult.put("deleteResult", 200);
        return ResponseEntity.ok(deleteResult);
    }*/
}
