package com.ps.infra.context.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tbl_training")
public class TrainingJpa {

    @Id
    @Column(columnDefinition = "binary(16)")
    private UUID id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer duration;

    public TrainingJpa() {
    }

    public TrainingJpa(UUID id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
