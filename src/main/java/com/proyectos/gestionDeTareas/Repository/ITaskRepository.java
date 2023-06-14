package com.proyectos.gestionDeTareas.Repository;


import com.proyectos.gestionDeTareas.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
}
