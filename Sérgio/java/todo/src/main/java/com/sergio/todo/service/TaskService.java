package com.sergio.todo.service;

import com.sergio.todo.enums.PRIORITY;
import com.sergio.todo.model.Task;
import com.sergio.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {



    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> create(@RequestBody Task task) {

        Task createdTask = repository.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = repository.findAll();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Optional<Task> task = repository.findById(id);

        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/task")
    public ResponseEntity<List<Task>> findByTitle(@RequestParam String title) {
        List<Task> tasks = repository.findByTitle(title);

        if (!tasks.isEmpty()) {
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tasks/priority")
    public ResponseEntity<List<Task>> findByPriority(@RequestParam PRIORITY priority) {
        List<Task> tasks = repository.findByPriority(priority);

        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a tarefa não for encontrada
        }

        Task existingTask = repository.findById(id).orElse(null);

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setPriority(taskDetails.getPriority());

        Task updatedTask = repository.save(existingTask);

        return ResponseEntity.ok(updatedTask);
    }
}
