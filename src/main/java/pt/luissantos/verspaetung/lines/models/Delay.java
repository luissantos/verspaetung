package pt.luissantos.verspaetung.lines.models;

import javax.persistence.*;

@Entity()
public class Delay {

    @Id()
    Integer lineId;

    @OneToOne()
    @JoinColumn(name = "line_id")
    @MapsId("lineId")
    Line line;

    @Column(name = "delay")
    Integer delay;

    public Delay() {

    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}
