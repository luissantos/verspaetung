package pt.luissantos.verspaetung.stops.repostiories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pt.luissantos.verspaetung.stops.models.LineTime;
import pt.luissantos.verspaetung.stops.models.LineTimeId;

@Repository
public interface LineTimeRepository extends JpaRepository<LineTime, LineTimeId>, LineTimeRepositoryCustom {

}
