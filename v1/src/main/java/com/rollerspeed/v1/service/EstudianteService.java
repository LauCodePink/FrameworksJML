package com.rollerspeed.v1.service;

import com.rollerspeed.v1.Model.EstudianteModel;
import com.rollerspeed.v1.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired private EstudianteRepository repo;

    public List<EstudianteModel> listar() { return repo.findAll(); }
    public Optional<EstudianteModel> obtenerPorId(Long id) { return repo.findById(id); }
    public EstudianteModel guardar(EstudianteModel e) { return repo.save(e); }
    public void eliminar(Long id) { repo.deleteById(id); }
}
