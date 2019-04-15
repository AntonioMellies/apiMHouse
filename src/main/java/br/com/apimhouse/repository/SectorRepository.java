package br.com.apimhouse.repository;

import br.com.apimhouse.domain.Sector;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectorRepository extends MongoRepository<Sector,String> {
}
