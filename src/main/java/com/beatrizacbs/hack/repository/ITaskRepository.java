package com.beatrizacbs.hack.repository;

import com.beatrizacbs.hack.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends MongoRepository<Task, String> {

    public List<Task> getAllByParentId(String parentID);
}
