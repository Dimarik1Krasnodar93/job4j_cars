package ru.job4j.cars.model;

import ru.job4j.toone.User;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver {
    private int id;
    private String name;

    @ManyToMany
    private User user;
}
