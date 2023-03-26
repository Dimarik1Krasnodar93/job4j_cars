package ru.job4j.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.model.Car;
import ru.job4j.service.CarService;
import ru.job4j.service.PostService;
import ru.job4j.toone.Post;
import ru.job4j.toone.User;
import ru.job4j.util.UserAdditional;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    @GetMapping("/photo/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable("id") int id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(post.getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(post.getPhoto()));
    }

    @GetMapping("/post/{id}")
    public String formUpdatePost(Model model, @PathVariable("id") int id, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        Post post = postService.findById(id);
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        model.addAttribute("post", post);
        return "update";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "addPost";
    }

    @PostMapping("/createPost")
    public String createPost(Model model, @ModelAttribute Post post, HttpSession httpSession,
                             @RequestParam("file") MultipartFile file) throws IOException {
        post.setPhoto(file.getBytes());
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        post.setUser(user);
        postService.addPost(post);
        return "posts";
    }

    @PostMapping("/setSaled")
    public String setSaled(Model model, @ModelAttribute Post post, HttpSession httpSession) {
        post.setSaled(true);
        User user = UserAdditional.getFromHttpSession(httpSession);
//        if (!user.equals(post.getUser())) {
//            return "fail";
//        }
        postService.update(post);
        return "redirect:/posts";
    }

    @PostMapping("/updatePost")
    public String updatePost(Model model, @ModelAttribute Post post, HttpSession httpSession) {
        post.setSaled(true);
        postService.update(post);
        return "redirect:/posts";
    }
}
