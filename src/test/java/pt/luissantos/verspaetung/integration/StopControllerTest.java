package pt.luissantos.verspaetung.integration;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pt.luissantos.verspaetung.Application;
import pt.luissantos.verspaetung.common.services.ClockService;

import java.time.LocalTime;

import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class , StopControllerTest.Configuration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StopControllerTest extends BaseTestCase {


    @Autowired
    ClockService service;


    @Test
    public void testThatNextBusIsReturnedAccordingToTheSchedule() throws JSONException {


        doReturn(LocalTime.of(10,06,59)).when(service).current();

        ResponseEntity<String> response = get("/stops/3/next_vehicle");

        assertEquals("{\"line\":{\"id\":0,\"name\":\"M4\"},\"schedule\":\"10:07:00\"}",response.getBody(),true);


        doReturn(LocalTime.of(10,07,30)).when(service).current();

        response = get("/stops/3/next_vehicle");

        assertEquals("{ line : { id : 1 , name : \"200\"  },\"schedule\":\"10:08:00\" }",response.getBody(),true);

    }

    @Test
    public void testThatIfNoIsInexistentEndpointReturns404() {

        ResponseEntity<String> response = get("/stops/999/next_vehicle");

        Assert.assertEquals(404,response.getStatusCode().value());
    }

    @org.springframework.context.annotation.Configuration
    public static class Configuration {
        @Bean
        @Primary
        public ClockService clockService() {
            return Mockito.mock(ClockService.class);
        }
    }
}
