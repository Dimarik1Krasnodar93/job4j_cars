package ru.job4j.toone;

import lombok.Data;
import ru.job4j.cars.model.Car;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Table(name = "auto_post")
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String text;
    @Column (name = "created")
    private Timestamp created;

    @ManyToOne
    @JoinColumn(name = "auto_user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "participates",
    joinColumns = {@JoinColumn(name = "post_id")})
    private List<User> userList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "photo")
    private byte[] photo;

    @Column
    private boolean saled;

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", text='" + text + '\'' + '}';
    }
}
