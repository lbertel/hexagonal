package com.ps.domain.model.entity;

import java.util.UUID;

public class Training {

    private final UUID id;
    private final String name;
    private final Integer duration;

    public Training(UUID id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }
}
