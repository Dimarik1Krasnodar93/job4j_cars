package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

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
}
