package ru.tsagolov.springbootfirstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsagolov.springbootfirstapp.model.User;
import ru.tsagolov.springbootfirstapp.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "redirect:/showAllUsers";
    }

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
    public String addNewUsers(@ModelAttribute ("user") User user) {
        return "new-user-data";
    }

    @RequestMapping(value = "/saveNewUser", method = RequestMethod.POST)
    public String saveNewUsers(@ModelAttribute ("user") User user) {
        userService.save(user);
        return "redirect:/showAllUsers";
    }

    @RequestMapping(value ="/toEditUser", method = RequestMethod.POST)
    public String toEdit(Model model,Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit-user-data";
    }

    @RequestMapping(value ="/editUser", method = RequestMethod.POST)
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/showAllUsers";
    }

    @RequestMapping(value ="/deleteUser", method = RequestMethod.PATCH)
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/showAllUsers";
    }


}
