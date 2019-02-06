package pt.luissantos.verspaetung.stops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pt.luissantos.verspaetung.common.services.ClockService;
import pt.luissantos.verspaetung.lines.models.Line;
import pt.luissantos.verspaetung.stops.models.LineTime;
import pt.luissantos.verspaetung.stops.repostiories.LineTimeRepository;
import pt.luissantos.verspaetung.stops.services.BusStopService;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusStopServiceTest {


    @Mock
    ClockService clockService;

    @Mock
    LineTimeRepository repository;

    BusStopService busStopService;

    @Before
    public void setUp() throws Exception {
        busStopService = new BusStopService( repository,clockService);
    }

    @Test
    public void testThatIfNoScheduleIsAvailableForTodayThe1stBusNextMorningWillBeReturned() {

        doReturn(Optional.empty()).when(repository).findNextBus(any(),any());

        LineTime lt = new LineTime();
        lt.setLine(new Line(100,"FirstBusInTheMorning"));
        doReturn(Optional.of(lt)).when(repository).findFirstBus(eq(10));



        Line line = busStopService.findNextBus(10).get().getLine();

        Assert.assertEquals(new Line(100,"FirstBusInTheMorning"),line);
    }
}
