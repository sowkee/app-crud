package com.proyectos.gestionDeTareas.Repository;

import com.proyectos.gestionDeTareas.Entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpensesRepository extends JpaRepository<Expenses, Long> {
}
