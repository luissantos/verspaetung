package pt.luissantos.verspaetung.stops.models;

import javax.persistence.*;

@Entity
@Table( indexes = { @Index(name = "IDX_coordinates", columnList = "x,y") })
public class Stop {

    @Id
    @GeneratedValue
    @Column(name = "stop_id")
    Integer id;

    @Column(name = "x")
    Integer x;

    @Column(name = "y")
    Integer y;

    public Stop() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
