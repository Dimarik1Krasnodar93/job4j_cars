package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "car_driver", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false)
    })
    private Set<Driver> drivers = new HashSet<>();
}
