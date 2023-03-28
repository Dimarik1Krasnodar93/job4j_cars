package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_body_id")
    private Body body;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "car_driver", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false)
    })
    private Set<Driver> drivers = new HashSet<>();

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
