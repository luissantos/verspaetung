package pt.luissantos.verspaetung.stops.models;

import pt.luissantos.verspaetung.lines.models.Line;

import javax.persistence.*;
import java.time.LocalTime;

@Entity()
@Table( indexes = { @Index(name = "IDX_time", columnList = "time") })
public class LineTime {


    @EmbeddedId()
    private LineTimeId id;

    @ManyToOne
    @JoinColumn(name = "line_id")
    @MapsId("lineId")
    Line line;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    @MapsId("stopId")
    Stop stop;

    @Column(name = "time")
    LocalTime time;

    public LineTime() {
        id = new LineTimeId();
    }



    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}
