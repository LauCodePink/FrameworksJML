package com.rollerspeed.v1.service;

import com.rollerspeed.v1.Model.InstructoresModel;
import com.rollerspeed.v1.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository repo;

    public List<InstructoresModel> listar() {
        return repo.findAll();
    }

    public Optional<InstructoresModel> obtenerPorId(Long id) {
        return repo.findById(id);
    }

    public InstructoresModel guardar(InstructoresModel instructor) {
        return repo.save(instructor);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}