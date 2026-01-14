package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.usecases.DeleteTaskUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskGateway taskGateway;

    @Override
    @Transactional
    public void execute(Long id) {
        if (taskGateway.findById(id).isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada.");
        }
        taskGateway.deleteById(id);
    }
}
