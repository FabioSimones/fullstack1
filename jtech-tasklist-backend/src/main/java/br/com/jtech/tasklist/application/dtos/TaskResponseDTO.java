package br.com.jtech.tasklist.application.dtos;

import br.com.jtech.tasklist.core.domain.enums.StatusEnum;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private StatusEnum status;
}
