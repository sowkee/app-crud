package com.proyectos.gestionDeTareas.DTO;

import org.springframework.stereotype.Component;



@Component
public class ExpensesDTORequest {

    private long id;
    private int monto;

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
}
