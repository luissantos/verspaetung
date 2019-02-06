package pt.luissantos.verspaetung.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pt.luissantos.verspaetung.lines.models.Coordinate;
import pt.luissantos.verspaetung.lines.models.Line;
import pt.luissantos.verspaetung.lines.repositories.LineRepository;

import java.time.LocalTime;

@Component
public class DefaultLineService implements LineService {

    LineRepository lineRepository;

    @Autowired
    public DefaultLineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Override
    public Page<Line> searchLines(LocalTime time, Coordinate coordinate, int page, int size) {
        return lineRepository.searchLines(time,coordinate.getX(),coordinate.getY(), PageRequest.of(page,size));
    }
}
