package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.ListAllTasksUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListAllTasksUseCaseImpl implements ListAllTasksUseCase {

    private final TaskGateway taskGateway;

    @Override
    @Transactional(readOnly = true)
    public List<Task> execute() {
        return taskGateway.findAll();
    }
}
