package br.com.apimhouse.repository;

import br.com.apimhouse.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    User findByUsername(String username);

}
