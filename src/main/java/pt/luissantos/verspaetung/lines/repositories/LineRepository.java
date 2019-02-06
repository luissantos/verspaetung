package pt.luissantos.verspaetung.lines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.luissantos.verspaetung.lines.models.Line;

public interface LineRepository extends JpaRepository<Line,Integer>, LineRepositoryCustom {


    @Query("SELECT l from Line l where l.name = ?1")
    public Line findLineByName(String name);
}
