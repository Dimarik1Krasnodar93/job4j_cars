package ru.job4j.toone;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auto_user")
public class User {
    @Id
    private int id;
    @Column
    private String login;
    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_user")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(name = "participates",
            joinColumns = {@JoinColumn(name = "user_id")})
    private List<User> userList;


}
