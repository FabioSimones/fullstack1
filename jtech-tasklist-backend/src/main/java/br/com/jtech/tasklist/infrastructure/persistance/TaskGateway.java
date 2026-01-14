package br.com.jtech.tasklist.infrastructure.persistance;

import br.com.jtech.tasklist.core.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskGateway {
    Task save(Task task);
    List<Task> findAll();
    Optional<Task> findById(Long id);
    void deleteById(Long id);
}
