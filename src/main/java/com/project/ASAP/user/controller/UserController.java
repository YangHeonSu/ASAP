package com.project.ASAP.user.controller;

import com.project.ASAP.user.domain.UserDTO;
import com.project.ASAP.user.repository.UserRepository;
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
       Optional<UserDTO> user = userService.findById(id);
       if (user.isPresent()) {
           model.addAttribute("user", user.get());
       }
       // return Optional.ofNullable(userRepository.findById(id).get()).orElseThrow(() -> new IllegalArgumentException("user not exist"));

        return "users/userDetail";
    }
}
