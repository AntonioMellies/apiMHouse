package br.com.apimhouse.repository;

import br.com.apimhouse.domain.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepository extends MongoRepository<Sensor,String> {

}
