package ru.job4j.toone;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "PRICE_HISTORY")
public class PriceHistory {
    @Id
    private int id;
    @Column
    private long before;
    @Column
    private long after;
    @Column
    private Timestamp created;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Post> posts;

}