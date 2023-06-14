package com.proyectos.gestionDeTareas.DTO;

import com.proyectos.gestionDeTareas.Entity.Expenses;
import com.proyectos.gestionDeTareas.Entity.Task;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Component
public class UserDTORequest {
    private long id;
    private String userName;
    private String lastName;
    private String userPassword;
    private List<Task> userTask;
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
