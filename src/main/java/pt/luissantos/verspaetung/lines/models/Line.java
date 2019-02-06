package pt.luissantos.verspaetung.lines.models;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table( indexes = { @Index(name = "IDX_LineName", columnList = "line_name") })
public class Line {


    @Id
    @GeneratedValue
    @Column(name = "line_id")
    private Integer id;


    @Column(name = "line_name")
    private String name;

    public Line() {

    }

    public Line(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(id, line.id) &&
                Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
