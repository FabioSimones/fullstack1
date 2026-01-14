package br.com.jtech.tasklist.core.usecases;

import br.com.jtech.tasklist.core.domain.Task;

public interface CreateTaskUseCase {
    Task execute (Task task);
}
