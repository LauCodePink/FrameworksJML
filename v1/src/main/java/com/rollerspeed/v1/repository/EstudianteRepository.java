package com.rollerspeed.v1.repository;

import com.rollerspeed.v1.Model.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {}