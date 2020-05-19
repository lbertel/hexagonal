package com.ps.infra.controllers;

import com.ps.app.create.handler.TrainingCreateHandler;
import com.ps.domain.model.entity.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/formacion/training")
public class TrainingCreatePostController {

    private final TrainingCreateHandler handler;
    private static final Logger logger = LoggerFactory.getLogger(TrainingCreatePostController.class);

    public TrainingCreatePostController(TrainingCreateHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TrainingRequest request){

        Training response = this.handler.execute(request.getId(), request.getName(), request.getDuration());

        return new ResponseEntity( response, HttpStatus.CREATED );
    }

}

class TrainingRequest{

    private UUID id;
    private String name;
    private Integer duration;

    public TrainingRequest() {
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

    @Override
    public String toString() {
        return "TrainingRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
