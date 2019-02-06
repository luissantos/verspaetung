package pt.luissantos.verspaetung.stops.models;

import pt.luissantos.verspaetung.lines.models.Line;

import java.time.LocalTime;

public class NextVehicle {

    Line line;

    LocalTime schedule;

    public NextVehicle(Line line, LocalTime schedule) {
        this.line = line;
        this.schedule = schedule;
    }

    public Line getLine() {
        return line;
    }

    public LocalTime getSchedule() {
        return schedule;
    }
}
