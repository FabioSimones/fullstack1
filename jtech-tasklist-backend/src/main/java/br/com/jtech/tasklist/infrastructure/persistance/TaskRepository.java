package br.com.jtech.tasklist.infrastructure.persistance;

import br.com.jtech.tasklist.core.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>, TaskGateway {
}
