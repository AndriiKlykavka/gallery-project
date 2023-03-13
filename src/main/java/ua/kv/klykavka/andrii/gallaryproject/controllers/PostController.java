package ua.kv.klykavka.andrii.gallaryproject.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.kv.klykavka.andrii.gallaryproject.models.Post;
import ua.kv.klykavka.andrii.gallaryproject.services.PostService;

import javax.validation.Valid;

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
        model.addAttribute("activePost", service.getPost(new ObjectId(id)));
        return "post-page";
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam String id){
        service.deletePost(id);
        return "redirect:/";
    }

    @RequestMapping("/create")
    public String createPost(Model model){
        model.addAttribute("newPost", new Post());
        return "add-page";
    }

    @PostMapping("/add")
    public String addPost(@Valid @ModelAttribute("newPost") Post post, BindingResult result){
        if(result.hasErrors()){
            return "add-page";
        }

        service.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPost(@RequestParam String id, Model model){
        model.addAttribute("editedPost", service.getPost(new ObjectId(id)));

        return "edit-page";
    }

    @PostMapping("/edit/confirm")
    public String confirmEdit(@ModelAttribute("editedPost") Post post){
        service.editPost(post);
        return "redirect:/";
    }
}
