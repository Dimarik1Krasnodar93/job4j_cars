package ru.job4j.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "entities")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
}
