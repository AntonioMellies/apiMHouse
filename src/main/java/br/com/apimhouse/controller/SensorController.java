package br.com.apimhouse.controller;

import br.com.apimhouse.dto.SensorDTO;
import br.com.apimhouse.domain.Sensor;
import br.com.apimhouse.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Sensor> find(@PathVariable String id) {
        Sensor obj = sensorService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody SensorDTO sensorDto){
        Sensor sensor = sensorService.fromDTO(sensorDto);
        sensor = sensorService.insert(sensor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(sensor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        sensorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public String update(){

        return "Sensor - save";
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Sensor> getAll(){

        return null;
    }

}
