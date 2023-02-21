package ru.job4j.repository;

import ru.job4j.cars.model.Car;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
}
