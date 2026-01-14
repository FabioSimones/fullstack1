package br.com.jtech.tasklist.application.controllers;

import br.com.jtech.tasklist.core.domain.Task;
import br.com.jtech.tasklist.core.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final ListAllTasksUseCase listAllTasksUseCase;
    private final FindTaskByIdUseCase findTaskByIdUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createTaskUseCase.execute(task));
    }

    @GetMapping
    public List<Task> listAll() {
        return listAllTasksUseCase.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return findTaskByIdUseCase.execute(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(updateTaskUseCase.execute(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteTaskUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
