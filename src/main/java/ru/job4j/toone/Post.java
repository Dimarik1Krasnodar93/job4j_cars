package ru.job4j.toone;

import lombok.Data;
import ru.job4j.cars.model.Car;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Table(name = "aoto_post")
@Entity
@Data
public class Post {
    @Id
    private int id;
    @Column
    private String text;
    @Column
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "auto_user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "participates",
    joinColumns = {@JoinColumn(name = "post_id")})
    private List<User> userList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<PriceHistory> priceHistoryList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
