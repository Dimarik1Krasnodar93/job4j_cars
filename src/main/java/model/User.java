package model;

import javax.persistence.*;

@Entity
@Table(name = "auto_user")
public class User {
    @Id
    private int id;
    @Column
    private String login;
    @Column
    private String password;
}
