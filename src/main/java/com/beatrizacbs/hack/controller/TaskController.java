package com.beatrizacbs.hack.controller;

import com.beatrizacbs.hack.model.Task;
import com.beatrizacbs.hack.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@Controller
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllAvaliableTasks(){
        return ResponseEntity.ok(taskService.getDefaultTasks());
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/parent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAvaliableTasksByParent(@PathVariable(value = "id") String id){
        return ResponseEntity.ok(taskService.getTasksByParentId(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/{child-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createTask(@PathVariable(value = "child-id") String userId, @RequestBody Task task){
        try {
            return ResponseEntity.ok(taskService.createTask(userId, task));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/conclude/{child-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity concludeTask(@PathVariable(value = "child-id") String childId, @RequestBody Task task){
        try {
            return ResponseEntity.ok(taskService.concludeTask(childId, task));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
