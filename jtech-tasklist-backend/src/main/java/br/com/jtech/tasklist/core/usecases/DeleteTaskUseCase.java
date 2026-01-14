package br.com.jtech.tasklist.core.usecases;

import br.com.jtech.tasklist.core.domain.Task;

public interface DeleteTaskUseCase {
    void execute(Long id);
}
