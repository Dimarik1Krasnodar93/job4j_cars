package ru.job4j.toone;

import org.hibernate.dialect.PostgreSQL9Dialect;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "aoto_post")
@Entity
public class Post {
    @Id
    private int id;
    private String text;
    private Timestamp timestamp;

    @JoinColumn(name = "auto_user")
    private User user;

    @ManyToMany
    @JoinTable(name = "participates",
    joinColumns = {@JoinColumn(name = "post_id")})
    private List<User> userList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private PriceHistory priceHistory;
}
