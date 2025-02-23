package com.actividadpractica.ActividadPractica5.service;


import com.actividadpractica.ActividadPractica5.model.Task;
import com.actividadpractica.ActividadPractica5.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    //crear una tarea
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    //ver la lista de tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();

    }

    public Optional<Task> updateTask(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setPriority(taskDetails.getPriority());
            task.setStatus(taskDetails.getStatus());
            return taskRepository.save(task);
        });
    }

    // Eliminar una tarea
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
