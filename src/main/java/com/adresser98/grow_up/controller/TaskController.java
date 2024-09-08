package com.adresser98.grow_up.controller;

import com.adresser98.grow_up.api.Task;
import com.adresser98.grow_up.api.TaskGroup;
import com.adresser98.grow_up.api.Tasks;
import com.adresser98.grow_up.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add-task")
    public ResponseEntity addTask(@RequestBody Task addTask) {
        return ResponseEntity.ok(taskService.addTask(addTask));
    }

    @PostMapping("/add-tasks")
    public ResponseEntity addTasks(@RequestBody Tasks addTasks) {
        return ResponseEntity.ok(taskService.addTasks(addTasks));
    }

    @GetMapping("/get-tasks")
    public Set<String> getTasks(@RequestParam String taskGroup) {
        return taskService.getTasks(taskGroup);
    }

    @PostMapping("/delete-task")
    public ResponseEntity deleteTask(@RequestBody Task deleteTask) {
        return ResponseEntity.ok(taskService.deleteTask(deleteTask));
    }

    @PostMapping("/delete-task-group")
    public ResponseEntity deleteTaskGroup(@RequestBody TaskGroup taskGroup) {
        return ResponseEntity.ok(taskService.deleteTaskGroup(taskGroup));
    }

}
