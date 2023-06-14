package com.proyectos.gestionDeTareas.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_expenses")
public class Expenses {
    @Id
    @Column(name = "id_expenses")
    private long id;
    @Column(name = "user_amount")
    private int monto;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
