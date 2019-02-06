package pt.luissantos.verspaetung.stops.repostiories;

import pt.luissantos.verspaetung.stops.models.LineTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class LineTimeRepositoryImpl implements LineTimeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    public Optional<LineTime> findFirstBus(Integer stop){
        return getFirst(entityManager.createQuery("Select lt from LineTime lt where stop_id = ?1 order by time,line_id",LineTime.class)
                .setParameter(1,stop)
                .setMaxResults(1));
    }

    public Optional<LineTime> findNextBus(Integer stop, LocalTime currentTime) {
        return getFirst(entityManager.createQuery("Select lt from LineTime lt where stop_id = ?1 and time >= ?2", LineTime.class)
                    .setParameter(1, stop)
                    .setMaxResults(1)
                    .setParameter(2, currentTime));
    }


    private Optional<LineTime> getFirst(Query query){

        List<LineTime> list = query.getResultList();


        if(list.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(list.get(0));
    }


}
