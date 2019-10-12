package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.Task;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ITaskService {

    public Task createTask(String userId, Task task) throws IOException;

    public List<Task> getDefaultTasks();

    public List<Task> getTasksByParentId(String parentId);

    public Task concludeTask(String childId, Task task) throws IOException;
}
