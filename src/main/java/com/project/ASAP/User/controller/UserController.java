package com.project.ASAP.User.controller;

import com.project.ASAP.User.Domain.User;
import com.project.ASAP.User.Domain.UserDTO;
import com.project.ASAP.User.repository.UserRepository;
import com.project.ASAP.User.service.UserService;
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

    private final UserRepository userRepository;

    /**
     * load Users list Page
     * @return Users LiST Page
     * @throws Exception
     */
    @GetMapping("/users/list")
    public String getUserListPage() throws Exception {
        return "users/userList";
    }

    /**
     * User Create Form
     * @return user Create Form Page
     * @throws Exception
     */
    @GetMapping("/users")
    public String createUserForm() throws Exception {
        return "users/userForm";
    }

    /**
     * @param model Model
     * @param id    User의 ID(PK)
     * @return userDetailPage
     * @throws Exception the Exception
     */
    @GetMapping("/users/detail/{id}")
    public String modifyUserForm(Model model, @PathVariable String id) throws Exception {
       Optional<User> user = userService.findById(id);
       if (user.isPresent()) {
           model.addAttribute("user", user.get());
       }
       // return Optional.ofNullable(userRepository.findById(id).get()).orElseThrow(() -> new IllegalArgumentException("user not exist"));

        return "users/userDetail";
    }
}
