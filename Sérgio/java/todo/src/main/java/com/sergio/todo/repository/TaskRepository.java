package com.sergio.todo.repository;

import com.sergio.todo.enums.PRIORITY;
import com.sergio.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitle(String title);

    List<Task> findByPriority(PRIORITY priority);
}
