package pt.luissantos.verspaetung.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.luissantos.verspaetung.lines.models.LineStatus;
import pt.luissantos.verspaetung.lines.repositories.DelayRepository;
import pt.luissantos.verspaetung.lines.repositories.LineRepository;

import java.util.Optional;

@Component
public class DefaultDelayService implements DelayService {


    private DelayRepository delayRepository;
    private LineRepository lineRepository;

    @Autowired
    public DefaultDelayService(DelayRepository delayRepository, LineRepository lineRepository) {
        this.delayRepository = delayRepository;
        this.lineRepository = lineRepository;
    }

    @Override
    public Optional<LineStatus> getDelayStatus(String line) {
        return Optional.ofNullable(lineRepository.findLineByName(line)).map( l -> delayRepository.findById(l.getId())
                    .map(d -> new LineStatus(d.getDelay() > 0)).orElse(new LineStatus(false)));
    }
}
