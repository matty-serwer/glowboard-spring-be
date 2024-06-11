package org.ltde.glowboard.model;

import jakarta.persistence.*;

@Entity
@Table(name = "effects")
public class Effect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, length = 500)
    private String description;

    // Optional: If you want to include specific parameters for the effect
    @Column(nullable = true)
    private String parameters;

    // Constructors, Getters, and Setters
    public Effect() {
    }

    public Effect(String name, String description, String parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}