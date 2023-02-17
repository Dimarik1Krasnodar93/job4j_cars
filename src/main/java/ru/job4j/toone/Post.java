package ru.job4j.toone;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "aoto_post")
@Entity
public class Post {
    @Id
    private int id;
    private String text;
    private Timestamp timestamp;

    @JoinColumn(name = "auto_user")
    private User user;
}
