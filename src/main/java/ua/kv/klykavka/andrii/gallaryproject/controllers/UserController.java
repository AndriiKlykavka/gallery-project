package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kv.klykavka.andrii.gallaryproject.models.User;
import ua.kv.klykavka.andrii.gallaryproject.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/registration")
    public String openRegistrationForm(Model model) {
        model.addAttribute("registeredUser", new User());
        System.out.println(model.getAttribute("registeredUser"));
        return "user-registration";
    }

    @RequestMapping("/confirm")
    public String confirmRegisteredUser(@ModelAttribute("registeredUser") User user, Model model) {
        System.out.println(user);
        service.registerUser(user);
        model.addAttribute("confirmedUser", user);
        return "redirect:/";
    }

}
