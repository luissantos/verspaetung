package pt.luissantos.verspaetung.stops.repostiories;

import pt.luissantos.verspaetung.stops.models.LineTime;

import java.time.LocalTime;
import java.util.Optional;

public interface LineTimeRepositoryCustom {

    Optional<LineTime> findFirstBus(Integer stop);
    Optional<LineTime> findNextBus(Integer stop, LocalTime currentTime);
}
