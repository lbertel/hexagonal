package com.ps.domain.port.dao;

import com.ps.domain.model.dto.TrainingDTO;
import com.ps.domain.model.entity.Training;

import java.util.List;
import java.util.UUID;

public interface TrainingDAO {

    List<TrainingDTO> getAllTraining();
    Training save(UUID id, String name, Integer duration);

}
