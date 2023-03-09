package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kv.klykavka.andrii.gallaryproject.services.PostService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PostService service;

    @Autowired
    public HomeController(PostService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("posts", service.getPosts());
        return "main-page";
    }


}
