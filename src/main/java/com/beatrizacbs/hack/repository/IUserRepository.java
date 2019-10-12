package com.beatrizacbs.hack.repository;

import com.beatrizacbs.hack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, Long> {

    public User findByEmail(String email);
}
