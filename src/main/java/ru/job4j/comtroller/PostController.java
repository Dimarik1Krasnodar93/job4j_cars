package ru.job4j.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.cars.model.Car;
import ru.job4j.service.CarService;
import ru.job4j.service.PostService;
import ru.job4j.toone.Post;
import ru.job4j.toone.User;
import ru.job4j.util.UserAdditional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {
    private PostService postService;
    private CarService carService;

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
        List<Car> cars = carService.findAllCars();
        return "addPost";
    }

    @PostMapping("/createPost")
    public String createPost(Model model, @ModelAttribute Post post, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        postService.addPost(post);
        return "posts";
    }

}
