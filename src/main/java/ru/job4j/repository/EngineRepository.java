package ru.job4j.repository;

import ru.job4j.cars.model.Engine;

import java.util.List;

public interface EngineRepository {
    List<Engine> findAll();
}
