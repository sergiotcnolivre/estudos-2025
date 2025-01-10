package com.sergio.todo.model;

import com.sergio.todo.enums.PRIORITY;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TASKS")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private PRIORITY priority;

    public Task(String title, String description, PRIORITY priority) {
        this.description = description;
        this.priority = priority;
        this.title = title;
    }
}
