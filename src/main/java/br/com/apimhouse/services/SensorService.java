package br.com.apimhouse.services;

import br.com.apimhouse.dto.SensorDTO;
import br.com.apimhouse.domain.Sensor;
import br.com.apimhouse.repository.SensorRepository;
import br.com.apimhouse.services.exceptions.DataIntegrityException;
import br.com.apimhouse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;


    public Sensor find(String id) {
        Optional<Sensor> obj = sensorRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Sensor.class.getName()));
    }

    public Sensor insert(Sensor sensor){
        sensor.setId(null);
        return sensorRepository.save(sensor);
    }

    public void delete(String id) {
        find(id);
        try {
            sensorRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o sensor");
        }

    }

    public Sensor fromDTO(SensorDTO objDto) {
        return new Sensor(objDto.getId(), objDto.getDescription());
    }
}
