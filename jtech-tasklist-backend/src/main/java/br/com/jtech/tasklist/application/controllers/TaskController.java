package br.com.jtech.tasklist.application.controllers;

import br.com.jtech.tasklist.application.dtos.*;
import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final ListAllTasksUseCase listAllTasksUseCase;
    private final FindTaskByIdUseCase findTaskByIdUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    // Criar Tarefa
    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@Valid @RequestBody CreateTaskRequestDTO dto) {
        Task task = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();

        Task saved = createTaskUseCase.execute(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    // Listar todas as tarefas
    @GetMapping
    public List<TaskResponseDTO> listAll() {
        return listAllTasksUseCase.execute()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // Buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
        return findTaskByIdUseCase.execute(id)
                .map(task -> ResponseEntity.ok(toResponse(task)))
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    // Atualizar tarefa
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id,
                                                  @Valid @RequestBody UpdateTaskRequestDTO dto) {
        Task task = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();

        Task updated = updateTaskUseCase.execute(id, task);
        return ResponseEntity.ok(toResponse(updated));
    }

    // Deletar tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteTaskUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    // Conversão para ResponseDTO
    private TaskResponseDTO toResponse(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }
}
