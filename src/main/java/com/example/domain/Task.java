package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "taskId")
    private Long id;

    @Column(name = "taskTitle")
    private String title;


    @Column(name = "taskDescription")
    private String description;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
