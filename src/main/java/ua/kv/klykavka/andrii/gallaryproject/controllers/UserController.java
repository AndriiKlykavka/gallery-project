package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ua.kv.klykavka.andrii.gallaryproject.models.User;
import ua.kv.klykavka.andrii.gallaryproject.services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        return "user-registration";
    }

    @RequestMapping("/confirm")
    public String confirmRegisteredUser(@ModelAttribute("registeredUser") User user, RedirectAttributes redirectAttributes,
                                        HttpServletResponse response, Model model) throws IOException {

        Cookie cookie = new Cookie("userCookie", user.getUserName());
        cookie.setMaxAge(2*60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/";
    }

}
