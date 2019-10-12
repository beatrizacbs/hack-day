package com.beatrizacbs.hack.repository;

import com.beatrizacbs.hack.model.Level;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILevelRepository extends MongoRepository<Level, String> {

    public Level findByLevelNumber(Integer levelNumber);

}
