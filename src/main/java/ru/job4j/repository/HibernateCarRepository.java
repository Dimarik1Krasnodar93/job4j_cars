package ru.job4j.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.HashMap;
import java.util.List;

@Repository
@AllArgsConstructor
public class HibernateCarRepository implements CarRepository {
    private final SessionFactory sessionFactory;
    private final CrudRepository crudRepository;
    public static final String FIND_ALL_CARS = "SELECT c FROM Car As c";

    public static final String FIND_ALL_CARS_WITH_ADDITIONAL = "SELECT c FROM Car As c JOIN FETCH c.engine_id ";

    @Override
    public List<Car> findAll() {
        return crudRepository.query(FIND_ALL_CARS, Car.class, new HashMap<>());
    }
    @Override
    public List<Car> findAllCarsWithAdditionalInfo() {
        return crudRepository.query(FIND_ALL_CARS_WITH_ADDITIONAL, Car.class, new HashMap<>());
    }

    @Override
    public Car save(Car car) {
        crudRepository.run(session -> session.save(car));
        return car;
    }
}
