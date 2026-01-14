package br.com.jtech.tasklist.core.usecases;

import br.com.jtech.tasklist.core.domain.Task;

import java.util.Optional;

public interface FindTaskByIdUseCase {
    Optional<Task> execute(Long id);
}
