package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kv.klykavka.andrii.gallaryproject.services.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

//    @RequestMapping("/see")
//    public String showPost(Model model) {
//        model.addAttribute("activePost", service.getPostById("6408c662893c8628e6b17829"));
//        System.out.println(service.getPostById("6408c662893c8628e6b17829"));
//        return "main-page";
//    }
}
