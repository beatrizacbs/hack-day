package com.beatrizacbs.hack.repository;

import com.beatrizacbs.hack.model.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IParentRepository extends MongoRepository<Parent, String> {

    public Parent findByEmail(String email);

}
