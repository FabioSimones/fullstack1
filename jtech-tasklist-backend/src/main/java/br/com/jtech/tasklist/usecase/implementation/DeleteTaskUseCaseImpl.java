package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.usecases.DeleteTaskUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskGateway taskGateway;

    @Override
    public void execute(Long id) {
        if (taskGateway.findById(id).isEmpty()) {
            throw new RuntimeException("Task not found");
        }
        taskGateway.deleteById(id);
    }
}
