package ru.job4j.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.PostService;

@Controller
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }
}
