package br.com.jtech.tasklist.core.usecases;

import br.com.jtech.tasklist.core.domain.Task;

public interface UpdateTaskUseCase {
    Task execute(Long id, Task task);
}
