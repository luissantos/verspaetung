package pt.luissantos.verspaetung.lines.services;

import org.springframework.data.domain.Page;
import pt.luissantos.verspaetung.lines.models.Coordinate;
import pt.luissantos.verspaetung.lines.models.Line;

import java.time.LocalTime;

public interface LineService {

    Page<Line> searchLines(LocalTime time, Coordinate coordinate, int page, int size);
}
