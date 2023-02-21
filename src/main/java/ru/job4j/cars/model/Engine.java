package ru.job4j.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entities")
public class Engine {
    @Id
    private int id;
    @Column
    private String name;
}
