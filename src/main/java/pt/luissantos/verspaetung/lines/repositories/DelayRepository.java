package pt.luissantos.verspaetung.lines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.luissantos.verspaetung.lines.models.Delay;

public interface DelayRepository extends JpaRepository<Delay, Integer> {

}
