package com.actividadpractica.ActividadPractica5.repository;

import com.actividadpractica.ActividadPractica5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
