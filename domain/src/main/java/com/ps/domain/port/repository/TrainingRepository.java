package com.ps.domain.port.repository;

import com.ps.domain.model.entity.Training;

public interface TrainingRepository {

    void create(Training training);

    Boolean exist(Training training);
}
