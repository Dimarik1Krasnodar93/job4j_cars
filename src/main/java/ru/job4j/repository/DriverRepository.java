package ru.job4j.repository;

import ru.job4j.cars.model.Driver;

import java.util.List;

public interface DriverRepository {
    List<Driver> findAll();
}
