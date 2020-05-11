package com.ps.app.query.handler;

import com.ps.domain.model.dto.TrainingDTO;
import com.ps.domain.port.dao.TrainingDAO;
import com.ps.domain.port.eventbus.NotificationQueryTrainingEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainingListHandler {

    private final TrainingDAO dao;
    private final NotificationQueryTrainingEvent event;

    public TrainingListHandler(TrainingDAO dao, NotificationQueryTrainingEvent event) {
        this.dao = dao;
        this.event = event;
    }

    public List<TrainingDTO> execute() {
        event.doNotification();
        return this.dao.getAllTraining();
    }
}
