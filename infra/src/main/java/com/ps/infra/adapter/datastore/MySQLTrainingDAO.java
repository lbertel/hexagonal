package com.ps.infra.adapter.datastore;

import com.ps.domain.model.dto.TrainingDTO;
import com.ps.domain.model.entity.Training;
import com.ps.domain.port.dao.TrainingDAO;
import com.ps.infra.context.jpa.TrainingJpa;
import com.ps.infra.context.jpa.TrainingJpaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class MySQLTrainingDAO implements TrainingDAO {

    private final TrainingJpaRepository repository;

    public MySQLTrainingDAO(TrainingJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<TrainingDTO> getAllTraining() {

        List<TrainingJpa> lstTrainingJpa = this.repository.findAll();
        List<TrainingDTO> lstTraining = new ArrayList<>();

        for (TrainingJpa jpa : lstTrainingJpa){
            lstTraining.add(new TrainingDTO(jpa.getName()));
        }

        return lstTraining;
    }

    @Override
    public Training save(UUID id, String name, Integer duration) {

        TrainingJpa training = repository.save(new TrainingJpa(id, name, duration));
        Training newTraining = new Training(training.getId(), training.getName(), training.getDuration());

        return newTraining;
    }
}
