package pt.luissantos.verspaetung.lines.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pt.luissantos.verspaetung.lines.models.Line;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;
import java.util.List;

public class LineRepositoryImpl  implements LineRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Line> searchLines(LocalTime time, Integer x, Integer y, Pageable pageable) {

        Long total = entityManager.createQuery(
                "Select count(l) from LineTime lt " +
                        "left join lt.stop stop " +
                        "left join lt.line l " +
                        "where stop.x = ?1 and stop.y = ?2 and lt.time = ?3", Long.class)
                .setParameter(1,x)
                .setParameter(2,y)
                .setParameter(3,time)
                .getSingleResult();

        List<Line> lines = entityManager.createQuery(
                "Select l from LineTime lt " +
                "left join lt.stop stop " +
                "left join lt.line l " +
                "where stop.x = ?1 and stop.y = ?2 and lt.time = ?3", Line.class)
                .setParameter(1,x)
                .setParameter(2,y)
                .setParameter(3,time)
                .getResultList();

        return new PageImpl<>(lines,pageable,total);

    }
}
