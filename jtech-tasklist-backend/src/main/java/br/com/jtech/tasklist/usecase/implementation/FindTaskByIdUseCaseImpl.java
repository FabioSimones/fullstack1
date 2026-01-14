package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.FindTaskByIdUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FindTaskByIdUseCaseImpl implements FindTaskByIdUseCase {

    private final TaskGateway taskGateway;

    @Override
    @Transactional(readOnly = true)
    public Optional<Task> execute(Long id) {
        return taskGateway.findById(id);
    }
}
