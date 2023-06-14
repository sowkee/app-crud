package com.proyectos.gestionDeTareas.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "ID_USER")
    private long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_LASTNAME")
    private String lastName;
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @OneToMany(mappedBy = "user")
    private List<Task> userTask;
    @OneToMany(mappedBy = "user")
    private List<Expenses> userExpenses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Task> getUserTask() {
        return userTask;
    }

    public void setUserTask(List<Task> userTask) {
        this.userTask = userTask;
    }

    public List<Expenses> getUserExpenses() {
        return userExpenses;
    }

    public void setUserExpenses(List<Expenses> userExpenses) {
        this.userExpenses = userExpenses;
    }
}
