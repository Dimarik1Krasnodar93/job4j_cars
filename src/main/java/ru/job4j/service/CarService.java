package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Car;
import ru.job4j.repository.CarRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public List<Car> findAllCarsWithAdditionalInfo() {
        return carRepository.findAllCarsWithAdditionalInfo();
    }
}
