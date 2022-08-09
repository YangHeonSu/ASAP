package com.project.ASAP.user.controller;

import com.project.ASAP.user.domain.UserDTO;
import com.project.ASAP.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * load Users list Page
     *
     * @return Users LiST Page
     * @throws Exception
     */
    @GetMapping("/users/list")
    public String loadUser() throws Exception {
        return "users/userList";
    }

    /**
     * User Create Form
     *
     * @return user Create Form Page
     * @throws Exception
     */
    @GetMapping("/users")
    public String createUserForm() throws Exception {
        return "users/userForm";
    }

  /*  *//**
     *
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     *//*
    @GetMapping("/users/detail/{id}")
    public String modifyUserForm(Model model, @PathVariable String id) throws Exception {
        Optional<UserDTO> user = userService.findUserById(id);
        UserDTO userInfo = user.get();
        model.addAttribute("user", userInfo);
        return "users/userDetail";
    }*/
}
