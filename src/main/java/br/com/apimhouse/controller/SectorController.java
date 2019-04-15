package br.com.apimhouse.controller;

import br.com.apimhouse.domain.Sector;
import br.com.apimhouse.domain.Sensor;
import br.com.apimhouse.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String save(){

        return "Sensor - save";
    }

    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public String remove(){

        return "Sensor - save";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(){

        return "Sensor - save";
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Sector> getAll(){

        return null;
    }

    @RequestMapping(value="/allsensor", method=RequestMethod.POST)
    public List<Sensor> getAllSensorPerSector(){

        return null;
    }
}

