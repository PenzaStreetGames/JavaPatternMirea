package com.hyberlet.study_1.controller;

import com.hyberlet.study_1.model.Task;
import com.hyberlet.study_1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id, @RequestBody Task task) {
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id) {
        taskRepository.markAsDone(id);
    }
}
