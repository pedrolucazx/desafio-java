package com.desafio.desafio.services;

import com.desafio.desafio.entities.Task;
import com.desafio.desafio.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        long pendingTask = taskRepository.countByStatus("pending");
        if(pendingTask >= 10){
            throw new RuntimeException("Não é permitido criar mais de 10 tarefas pendentes.");
        }
        task.setCreationDate(LocalDateTime.now());
        task.setStatus(Task.Status.PENDENTE);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAllByOrderByCreationDateAsc();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        return taskRepository.save(task);
    }

    public void deleteTask (Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));
        taskRepository.delete(task);
    }

    public Task changeTaskStatus(Long id, Task.Status status){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
