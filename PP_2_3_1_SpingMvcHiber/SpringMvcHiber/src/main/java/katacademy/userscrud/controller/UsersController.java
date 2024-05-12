package katacademy.userscrud.controller;

import katacademy.userscrud.model.User;
import katacademy.userscrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {


    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }


    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        System.out.println("new user");
        return "/user-create";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user-create";
        }

        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        Optional<User> userById = userService.getUserById(id);

        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "/edit-user";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit-user";
        }

        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }



}
