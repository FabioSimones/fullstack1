package br.com.jtech.tasklist.infrastructure.persistance;

import br.com.jtech.tasklist.core.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
