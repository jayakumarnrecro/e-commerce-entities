package org.example.evaluations.evaluation.models;

import jakarta.persistence.Id;

public abstract class BaseModel {
    @Id
    private Long id;

    private State state;
}
