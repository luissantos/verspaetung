package pt.luissantos.verspaetung.lines.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pt.luissantos.verspaetung.lines.models.Line;

import java.time.LocalTime;

public interface LineRepositoryCustom {

    Page<Line> searchLines(LocalTime time, Integer x, Integer y, Pageable pageable);
}
