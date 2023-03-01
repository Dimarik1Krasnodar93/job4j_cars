package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Engine;
import ru.job4j.repository.EngineRepository;

@Service
@AllArgsConstructor
public class EngineService {
    EngineRepository engineRepository;

    public void addEngine(Engine engine) {
        engineRepository.save(engine);
    }
}
