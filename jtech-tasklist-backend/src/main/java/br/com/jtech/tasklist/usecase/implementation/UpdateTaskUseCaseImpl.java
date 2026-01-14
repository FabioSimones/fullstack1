package br.com.jtech.tasklist.usecase.implementation;

import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.UpdateTaskUseCase;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskGateway taskGateway;

    @Override
    @Transactional
    public Task execute(Long id, Task task) {
        return taskGateway.findById(id)
                .map(existing -> {
                    existing.setTitle(task.getTitle());
                    existing.setDescription(task.getDescription());
                    existing.setStatus(task.getStatus());
                    return taskGateway.save(existing); })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada.")); }
}
