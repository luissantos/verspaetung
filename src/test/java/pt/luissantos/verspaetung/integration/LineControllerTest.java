package pt.luissantos.verspaetung.integration;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import pt.luissantos.verspaetung.Application;
import pt.luissantos.verspaetung.lines.repositories.LineRepository;
import pt.luissantos.verspaetung.stops.models.LineTime;
import pt.luissantos.verspaetung.stops.repostiories.BusStopRepository;
import pt.luissantos.verspaetung.stops.repostiories.LineTimeRepository;

import java.time.LocalTime;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LineControllerTest extends BaseTestCase {


    @Autowired
    LineTimeRepository lineTimeRepository;

    @Autowired
    BusStopRepository stopRepository;

    @Autowired
    LineRepository lineRepository;

    @Test
    public void testThatInexistentLineReturns404() throws Exception {

        ResponseEntity<String> response = get("/lines/S100/status");

        assertEquals("{ error : \"Resource not found\" }",response.getBody(),true);
        Assert.assertEquals(404,response.getStatusCode().value());


    }

    @Test
    public void testThatExistingLineReturnsDelayed() throws JSONException {

        ResponseEntity<String> response = get("/lines/S75/status");

        assertEquals("{ delayed : true}",response.getBody(),true);
        Assert.assertEquals(200,response.getStatusCode().value());

    }


    @Test
    public void testThatMultipleLinesAreFoundGivenTheSameCoordinatesAndTime() throws JSONException {

        LineTime lt = new LineTime();

        lt.setStop(stopRepository.findById(11).get());
        lt.setLine(lineRepository.findLineByName("M4"));
        lt.setTime(LocalTime.of(10,15,00));
        lineTimeRepository.saveAndFlush(lt);

        ResponseEntity<String> response = get("/lines/search?time=101500&x=5&y=7");

        JSONAssert.assertEquals( "{ page : { totalElements : 2 },  _embedded : { lineList : [ { id: 2, name : \"S75\" }, { id: 0, name : \"M4\" } ] } } ",response.getBody(),false);

    }
}
