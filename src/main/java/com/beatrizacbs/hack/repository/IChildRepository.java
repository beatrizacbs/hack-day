package com.beatrizacbs.hack.repository;

import com.beatrizacbs.hack.model.Child;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IChildRepository extends MongoRepository<Child, String> {

    public Child findByEmail(String email);
}
