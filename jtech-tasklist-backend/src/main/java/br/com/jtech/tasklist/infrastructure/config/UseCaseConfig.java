package br.com.jtech.tasklist.infrastructure.config;

import br.com.jtech.tasklist.core.usecases.*;
import br.com.jtech.tasklist.infrastructure.persistance.TaskGateway;
import br.com.jtech.tasklist.usecase.implementation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final TaskGateway taskGateway;

    public UseCaseConfig(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Bean
    public CreateTaskUseCase createTaskUseCase() {
        return new CreateTaskUseCaseImpl(taskGateway);
    }

    @Bean
    public ListAllTasksUseCase listAllTasksUseCase() {
        return new ListAllTasksUseCaseImpl(taskGateway);
    }

    @Bean
    public FindTaskByIdUseCase findTaskByIdUseCase() {
        return new FindTaskByIdUseCaseImpl(taskGateway);
    }

    @Bean
    public UpdateTaskUseCase updateTaskUseCase() {
        return new UpdateTaskUseCaseImpl(taskGateway);
    }

    @Bean
    public DeleteTaskUseCase deleteTaskUseCase() {
        return new DeleteTaskUseCaseImpl(taskGateway);
    }

}
