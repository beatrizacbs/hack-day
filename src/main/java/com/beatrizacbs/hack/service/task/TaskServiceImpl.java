package com.beatrizacbs.hack.service.task;

import com.beatrizacbs.hack.model.Child;
import com.beatrizacbs.hack.model.Task;
import com.beatrizacbs.hack.repository.IChildRepository;
import com.beatrizacbs.hack.repository.ITaskRepository;
import com.beatrizacbs.hack.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private IChildRepository childRepository;

    @Override
    public Task createTask(String userId, Task task) throws IOException {
        Optional<Child> childOptional = childRepository.findById(userId);
        taskRepository.save(task);
        if (childOptional.isPresent()) {
            Child child = childOptional.get();
            if (child.getTodoTasks() == null) {
                child.setTodoTasks(new ArrayList<>());
            }
            child.getTodoTasks().add(task.getId());
            childRepository.save(child);
        } else {
            throw new IOException("Criança não encontrada");
        }
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getDefaultTasks() {
        return taskRepository.getAllByParentId(null);
    }

    @Override
    public List<Task> getTasksByParentId(String parentId) {
        return taskRepository.getAllByParentId(parentId);
    }

    @Override
    public Task concludeTask(String childId, Task task) throws IOException {
        Optional<Child> childOptional = childRepository.findById(childId);
        if(childOptional.isPresent()){
            Child child = childOptional.get();
            if(child.getTodoTasks() != null){
                child.getTodoTasks().removeIf(taskp -> taskp.equals(task.getId()));
                if(child.getTasksConcluded() == null){
                    child.setTasksConcluded(new ArrayList<>());
                }
                child.getTasksConcluded().add(task.getId());
                child.addExperience(task.getXpValue());
                childRepository.save(child);
                return task;
            }else{
                throw new IOException("Você não pode concluir uma tarefa que não está na sua lista de tarefas a fazer");
            }
        }else{
            throw new IOException("A criança não está cadastrada no banco de dados");
        }
    }
}
