package ru.tsagolov.springbootfirstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsagolov.springbootfirstapp.model.User;
import ru.tsagolov.springbootfirstapp.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/showAllUsers";
    }

    @GetMapping("/showAllUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/addNewUser")
    public String addNewUsers(@ModelAttribute ("user") User user) {
        return "new-user-data";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUsers(@ModelAttribute ("user") User user) {
        userService.saveUser(user);
        return "redirect:/showAllUsers";
    }

    @PostMapping("/toEditUser")
    public String toEditUser(Model model,Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user-data";
    }

    //@RequestMapping(value ="/editUser", method = RequestMethod.PATCH)
    @PatchMapping("/editUser")
    public String editUser(User user) {
        userService.editUser(user);
        return "redirect:/showAllUsers";
    }

    @PostMapping("/deleteUser")
    public String deleteUserById(Long id) {
        userService.deleteUserById(id);
        return "redirect:/showAllUsers";
    }


}
