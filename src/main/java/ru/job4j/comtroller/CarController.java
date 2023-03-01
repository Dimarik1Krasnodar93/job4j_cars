package ru.job4j.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cars.model.Car;
import ru.job4j.repository.CarRepository;
import ru.job4j.service.CarService;

@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    CarService carService;

    @GetMapping("/formAdd")
    public String formAdd(@ModelAttribute Car car) {
        carService.addCar(car);
        return "addCar";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/index";
    }
}
