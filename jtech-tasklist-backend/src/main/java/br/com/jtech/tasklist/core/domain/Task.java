package br.com.jtech.tasklist.core.domain;

import br.com.jtech.tasklist.core.domain.enums.StatusEnum;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}

