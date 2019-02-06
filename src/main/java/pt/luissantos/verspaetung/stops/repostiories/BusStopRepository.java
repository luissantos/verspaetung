package pt.luissantos.verspaetung.stops.repostiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pt.luissantos.verspaetung.stops.models.Stop;

public interface BusStopRepository extends JpaRepository<Stop,Integer> {

}
