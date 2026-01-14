package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.ListAllTaskUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllTasksUseCaseImpl implements ListAllTaskUseCase {

    private final TaskGateway taskGateway;

    @Override
    public List<Task> execute() {
        return taskGateway.findAll();
    }
}
