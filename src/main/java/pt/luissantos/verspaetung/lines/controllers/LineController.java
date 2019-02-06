package pt.luissantos.verspaetung.lines.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.luissantos.verspaetung.lines.models.Coordinate;
import pt.luissantos.verspaetung.lines.models.Line;
import pt.luissantos.verspaetung.lines.models.LineStatus;
import pt.luissantos.verspaetung.lines.services.DelayService;
import pt.luissantos.verspaetung.lines.services.LineService;
import pt.luissantos.verspaetung.lines.utils.TimeUtil;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@RestController
@Api(value="Lines", description="Operations pertaining to public transportation lines")
public class LineController {

    DelayService delayService;

    LineService lineService;

    @Autowired
    public LineController(DelayService delayService, LineService lineService) {
        this.delayService = delayService;
        this.lineService = lineService;
    }

    @ApiOperation(value = "Get the delay status for a given line",response = LineStatus.class)
    @RequestMapping(value = "/lines/{name}/status",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Optional<LineStatus> getLineStatus(@PathVariable("name") String name){
        return delayService.getDelayStatus(name);
    }

    @ApiOperation(value = "Searches lines based on stop positioning and time of the day")
    @RequestMapping(value = "/lines/search",method = RequestMethod.GET, params = {"time", "x", "y"},produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResources<Line> findLine(@ApiParam(value = "Format: HHMMSS",required = true) @RequestParam("time") String time, @RequestParam("x")  Integer x, @RequestParam("y")  Integer y, @ApiIgnore() Pageable pageable, @ApiIgnore() PagedResourcesAssembler assembler){

        final Link link = searchLink(time,x,y,pageable,assembler);

        Page<Line> page = lineService.searchLines(TimeUtil.parseTime(time), Coordinate.of(x,y),pageable.getPageNumber(),pageable.getPageSize());

        return assembler.toResource(page,link);
    }

    private Link searchLink(String time,Integer x, Integer y,Pageable pageable, PagedResourcesAssembler assembler){
        return ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(
                        LineController.class).findLine(time,x,y, pageable, assembler)).withSelfRel();
    }

}
