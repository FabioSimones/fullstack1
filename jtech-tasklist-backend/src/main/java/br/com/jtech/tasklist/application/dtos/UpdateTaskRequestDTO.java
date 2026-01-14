package br.com.jtech.tasklist.application.dtos;

import br.com.jtech.tasklist.core.domain.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTaskRequestDTO {

    @NotBlank(message = "O título da tarefa é obrigatório")
    private String title;

    private String description;

    private StatusEnum status;
}
