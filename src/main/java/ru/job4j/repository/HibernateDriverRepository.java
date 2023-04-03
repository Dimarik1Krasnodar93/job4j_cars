package ru.job4j.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Driver;

import java.util.HashMap;
import java.util.List;

@Repository
@AllArgsConstructor
public class HibernateDriverRepository implements DriverRepository {
    private final CrudRepository crudRepository;
    public static final String FIND_ALL_DRIVERS = "SELECT d FROM Driver As d";

    @Override
    public List<Driver> findAll() {
        return crudRepository.query(FIND_ALL_DRIVERS, Driver.class, new HashMap<>());    }
}
