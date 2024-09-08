package com.adresser98.grow_up.service;

import com.adresser98.grow_up.api.Tasks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class TaskManager {

    @Autowired
    private Map<String, Set<String>> tasksByGroup;

    public Set<String> addTask(String taskGroup, String task) {
        tasksByGroup.computeIfAbsent(taskGroup, t -> new HashSet<>());
        tasksByGroup.get(taskGroup).add(task);

        return tasksByGroup.get(taskGroup);
    }

    public Set<String> addTasks(Tasks tasks) {
        tasksByGroup.computeIfAbsent(tasks.getTaskGroup(), t -> new HashSet<>());
        tasks.getTasks().forEach(task -> tasksByGroup.get(tasks.getTaskGroup()).add(task));

        return tasksByGroup.get(tasks.getTaskGroup());
    }

    public Set<String> getTasks(String taskGroup) {
        return tasksByGroup.getOrDefault(taskGroup, new HashSet<>());
    }

    public Set<String> deleteTask(String taskGroup, String task) {
        if (tasksByGroup.containsKey(taskGroup)) {
            tasksByGroup.get(taskGroup).remove(task);
            return tasksByGroup.get(taskGroup);
        }
        return new HashSet<>();
    }

    public boolean deleteTaskGroup(String taskGroup) {
        if (tasksByGroup.containsKey(taskGroup)) {
            tasksByGroup.remove(taskGroup);
            return true;
        }
        log.info("deleteTaskGroup: taskGroup={} does not exist. Available task groups={}", taskGroup, tasksByGroup.keySet());
        return false;
    }


}
