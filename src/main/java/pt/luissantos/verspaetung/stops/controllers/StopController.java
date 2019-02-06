package pt.luissantos.verspaetung.stops.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.luissantos.verspaetung.stops.models.NextVehicle;
import pt.luissantos.verspaetung.stops.services.BusStopService;

import java.util.Optional;

@RestController
@Api(value="Stops", description="Operations pertaining to public transportation stops")
public class StopController {

    @Autowired
    BusStopService busStopService;

    @ApiOperation(value = "Finds the next vehicle to stop at a given stop",response = NextVehicle.class)
    @RequestMapping(value = "/stops/{id}/next_vehicle",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<NextVehicle> getNextVehicle(@PathVariable(value = "id") Integer stopId){
        return busStopService.findNextBus(stopId);
    }

}
