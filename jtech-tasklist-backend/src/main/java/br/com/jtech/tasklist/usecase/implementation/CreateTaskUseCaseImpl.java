package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.CreateTaskUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskGateway taskGateway;

    @Override
    @Transactional
    public Task execute(Task task) {
        return taskGateway.save(task);
    }
}
