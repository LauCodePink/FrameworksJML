package com.rollerspeed.v1.repository;

import com.rollerspeed.v1.Model.ClasesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<ClasesModel, Long> {}