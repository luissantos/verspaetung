package pt.luissantos.verspaetung.lines.models;

public class LineStatus {

    boolean delayed;

    public LineStatus(boolean delayed) {
        this.delayed = delayed;
    }

    public boolean isDelayed() {
        return delayed;
    }
}
