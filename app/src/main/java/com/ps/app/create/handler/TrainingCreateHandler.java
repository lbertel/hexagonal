package com.ps.app.create.handler;

import com.ps.domain.model.entity.Training;
import com.ps.domain.port.dao.TrainingDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TrainingCreateHandler {

    private final TrainingDAO dao;

    public TrainingCreateHandler(TrainingDAO dao) {
        this.dao = dao;
    }

    public Training execute(UUID id, String name, Integer duration) {
        return  this.dao.save(id, name, duration);
    }

}
