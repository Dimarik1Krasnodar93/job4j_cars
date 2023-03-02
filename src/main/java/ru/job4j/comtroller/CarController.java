package ru.job4j.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cars.model.Car;
import ru.job4j.repository.CarRepository;
import ru.job4j.service.CarService;
import ru.job4j.toone.User;
import ru.job4j.util.UserAdditional;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@RequestMapping("/cars")
@Controller
public class CarController {
    CarService carService;

    @GetMapping("/formAdd")
    public String formAdd(Model model, @ModelAttribute Car car, HttpSession httpSession) {
        User user = UserAdditional.getFromHttpSession(httpSession);
        model.addAttribute("user", user);
        return "addCar";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/index";
    }
}
