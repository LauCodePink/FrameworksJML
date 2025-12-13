package com.rollerspeed.v1.repository;

import com.rollerspeed.v1.Model.InstructoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<InstructoresModel, Long> {}