package com.ps.infra.context.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingJpaRepository extends JpaRepository<TrainingJpa, UUID> {
}
