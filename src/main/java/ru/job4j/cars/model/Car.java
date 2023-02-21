package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    private int id;
    @Column
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;
    @Column
    private Set<Driver> drivers = new HashSet<>();
}
