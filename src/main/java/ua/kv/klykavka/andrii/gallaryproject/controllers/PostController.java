package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kv.klykavka.andrii.gallaryproject.services.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/see")
    public String showPost(@RequestParam String id,  Model model) {
        model.addAttribute("activePost", service.getPostById(new ObjectId(id)));
        return "post-page";
    }
}
