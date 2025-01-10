package com.sergio.todo.controller;

import com.sergio.todo.model.Task;
import com.sergio.todo.enums.PRIORITY;
import com.sergio.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    // Injeção de dependência do TaskService
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Cria uma nova tarefa.
     *
     * @param task A tarefa a ser criada
     * @return A tarefa criada com status 201 Created
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    /**
     * Recupera todas as tarefas.
     *
     * @return Lista de todas as tarefas com status 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return taskService.findAll();
    }

    /**
     * Recupera uma tarefa específica pelo ID.
     *
     * @param id O ID da tarefa a ser recuperada
     * @return A tarefa encontrada ou 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    /**
     * Recupera tarefas por título.
     *
     * @param title O título para filtrar as tarefas
     * @return Lista de tarefas com o título fornecido
     */
    @GetMapping("/title")
    public ResponseEntity<List<Task>> getTasksByTitle(@RequestParam String title) {
        return taskService.findByTitle(title);
    }

    /**
     * Recupera tarefas por prioridade.
     *
     * @param priority A prioridade para filtrar as tarefas
     * @return Lista de tarefas com a prioridade fornecida
     */
    @GetMapping("/priority")
    public ResponseEntity<List<Task>> getTasksByPriority(@RequestParam PRIORITY priority) {
        return taskService.findByPriority(priority);
    }

    /**
     * Atualiza uma tarefa existente.
     *
     * @param id          O ID da tarefa a ser atualizada
     * @param taskDetails Os novos detalhes da tarefa
     * @return A tarefa atualizada com status 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    /**
     * Deleta uma tarefa pelo ID.
     *
     * @param id O ID da tarefa a ser deletada
     * @return Status 204 No Content se a exclusão for bem-sucedida, ou 404 Not Found se a tarefa não for encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        return taskService.deleteById(id);
    }
}
