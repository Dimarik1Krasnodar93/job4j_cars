package ru.job4j.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "car_body")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Override
    public String toString() {
        return "Body{"
                + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
