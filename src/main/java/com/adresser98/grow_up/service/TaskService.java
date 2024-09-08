package com.adresser98.grow_up.service;

import com.adresser98.grow_up.api.Task;
import com.adresser98.grow_up.api.TaskGroup;
import com.adresser98.grow_up.api.Tasks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class TaskService {

    @Autowired
    private TaskManager taskManager;

    public Set<String> addTask(Task addTask) {
        return taskManager.addTask(addTask.getTaskGroup(), addTask.getTask());
    }

    public Set<String> addTasks(Tasks addTasks) {
        return taskManager.addTasks(addTasks);
    }


    public Set<String> getTasks(String taskGroup) {
        return taskManager.getTasks(taskGroup);
    }

    public Set<String> deleteTask(Task deleteTask) {
        return taskManager.deleteTask(deleteTask.getTaskGroup(), deleteTask.getTask());
    }

    public boolean deleteTaskGroup(TaskGroup taskGroup) {
        return taskManager.deleteTaskGroup(taskGroup.getTaskGroup());
    }

}
