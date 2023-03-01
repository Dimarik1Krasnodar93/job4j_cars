package ru.job4j.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.service.PostService;
import ru.job4j.toone.User;
import ru.job4j.util.UserAdditional;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/posts")
    public String getAllPosts(Model model, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        return "addPost";
    }

}
