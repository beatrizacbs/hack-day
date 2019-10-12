package com.beatrizacbs.hack.repository;

import com.beatrizacbs.hack.model.Dream;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDreamRepository extends MongoRepository<Dream, String> {
}
