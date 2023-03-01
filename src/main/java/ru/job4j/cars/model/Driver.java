package ru.job4j.cars.model;

import ru.job4j.toOne.User;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne
    private User user;
}
