package com.sergio.todo.service;

import com.sergio.todo.enums.PRIORITY;
import com.sergio.todo.model.Task;
import com.sergio.todo.repository.TaskRepository;
import com.sergio.todo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Cria uma nova tarefa no sistema.
     *
     * @param task A tarefa a ser criada
     * @return A tarefa criada com status 201 Created
     */
    public ResponseEntity<Task> create(Task task) {
        Task createdTask = repository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    /**
     * Recupera todas as tarefas do sistema.
     *
     * @return Lista de tarefas
     */
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = repository.findAll();
        return ResponseEntity.ok(tasks);
    }

    /**
     * Recupera uma tarefa específica pelo ID.
     *
     * @param id O ID da tarefa a ser recuperada
     * @return A tarefa encontrada ou 404 Not Found se não encontrada
     */
    public ResponseEntity<Task> findById(Long id) {
        Optional<Task> task = repository.findById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Recupera tarefas pelo título.
     *
     * @param title O título da tarefa a ser buscado
     * @return Lista de tarefas encontradas
     */
    public ResponseEntity<List<Task>> findByTitle(String title) {
        List<Task> tasks = repository.findByTitle(title);
        return ResponseEntity.ok(tasks);
    }

    /**
     * Recupera tarefas por prioridade.
     *
     * @param priority A prioridade para filtrar as tarefas
     * @return Lista de tarefas com a prioridade fornecida
     */
    public ResponseEntity<List<Task>> findByPriority(PRIORITY priority) {
        List<Task> tasks = repository.findByPriority(priority);
        return ResponseEntity.ok(tasks);
    }

    /**
     * Deleta uma tarefa pelo ID.
     *
     * @param id O ID da tarefa a ser excluída
     * @return 204 No Content caso a exclusão seja bem-sucedida ou 404 Not Found caso a tarefa não exista
     */
    public ResponseEntity<Void> deleteById(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza uma tarefa existente.
     *
     * @param id          O ID da tarefa a ser atualizada
     * @param taskDetails Os detalhes da tarefa para atualizar
     * @return A tarefa atualizada ou 404 Not Found se a tarefa não for encontrada
     */
    public ResponseEntity<Task> updateTask(Long id, Task taskDetails) {
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setPriority(taskDetails.getPriority());

        Task updatedTask = repository.save(existingTask);
        return ResponseEntity.ok(updatedTask);
    }
}
