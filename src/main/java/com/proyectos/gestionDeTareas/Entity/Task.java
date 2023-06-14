package com.proyectos.gestionDeTareas.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "users")
public class Task {
    @Id
    @Column(name = "id_task")
    private long id;
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "task_description")
    private String taskDescription;
    @CreationTimestamp
    @Column(name = "task_date")
    private Date taskDate;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
