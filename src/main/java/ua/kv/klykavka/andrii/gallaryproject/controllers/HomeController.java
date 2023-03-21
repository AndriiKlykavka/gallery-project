package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.services.PostService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PostService service;

    @Autowired
    public HomeController(PostService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String showHomePage(HttpServletRequest request, Model model) {
        model.addAttribute("posts", service.getPosts());

        Cookie[] cookies = request.getCookies();
        System.out.println(cookies == null);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userCookie")) {
                    model.addAttribute("userCookie", cookie.getValue());
                    break;
                }
            }
        }


        return "main-page";
    }
}
