package br.com.jtech.tasklist.core.usecases;

import br.com.jtech.tasklist.core.domain.Task;

import java.util.List;

public interface ListAllTaskUseCase {
    List<Task> execute();
}
