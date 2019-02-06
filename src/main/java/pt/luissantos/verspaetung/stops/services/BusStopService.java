package pt.luissantos.verspaetung.stops.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.luissantos.verspaetung.common.services.ClockService;
import pt.luissantos.verspaetung.stops.models.LineTime;
import pt.luissantos.verspaetung.stops.models.NextVehicle;
import pt.luissantos.verspaetung.stops.repostiories.LineTimeRepository;

import java.util.Optional;

@Component
public class BusStopService {


    private LineTimeRepository repository;
    private ClockService clockService;

    @Autowired
    public BusStopService(LineTimeRepository repository, ClockService clockService) {
        this.repository = repository;
        this.clockService = clockService;
    }

    public Optional<NextVehicle> findNextBus(Integer stop){

        Optional<LineTime> lt = repository.findNextBus(stop,clockService.current());

        return lt.map( lt1 -> new NextVehicle(lt1.getLine(),lt1.getTime())).map(Optional::of)
                  .orElseGet( () -> repository.findFirstBus(stop).map( lt1 -> new NextVehicle(lt1.getLine(),lt1.getTime())));


    }

}
