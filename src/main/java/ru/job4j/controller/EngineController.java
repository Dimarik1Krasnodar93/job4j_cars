package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cars.model.Engine;
import ru.job4j.service.EngineService;
import ru.job4j.toone.User;
import ru.job4j.util.UserAdditional;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@RequestMapping("/engines")
@Controller
public class EngineController {
    EngineService engineService;

    @GetMapping("/formAdd")
    public String formAdd(Model model, @ModelAttribute Engine engine, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        return "addEngine";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Engine engine) {
        engineService.addEngine(engine);
        return "redirect:/index";
    }
}
