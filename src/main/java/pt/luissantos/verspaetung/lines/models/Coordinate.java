package pt.luissantos.verspaetung.lines.models;

public class Coordinate {

    private Integer x,y;

    private Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public static Coordinate of(Integer x, Integer y){
        return new Coordinate(x,y);
    }
}
