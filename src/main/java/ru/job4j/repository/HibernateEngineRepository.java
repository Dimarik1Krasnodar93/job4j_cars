package ru.job4j.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;

import java.util.HashMap;
import java.util.List;

@Repository
@AllArgsConstructor
public class HibernateEngineRepository implements EngineRepository {
    private final CrudRepository crudRepository;
    public static final String FIND_ALL_ENGINES = "SELECT e FROM Engine As e";

    @Override
    public List<Engine> findAll() {

        return crudRepository.query(FIND_ALL_ENGINES, Engine.class, new HashMap<>());
    }

    @Override
    public Engine save(Engine engine) {
        crudRepository.run(session -> session.save(engine));
        return engine;
    }
}
