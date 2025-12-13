package com.rollerspeed.v1.service;

import com.rollerspeed.v1.Model.ClasesModel;
import com.rollerspeed.v1.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository repo;

    public List<ClasesModel> listar() {
        return repo.findAll();
    }

    public Optional<ClasesModel> obtenerPorId(Long id) {
        return repo.findById(id);
    }

    public ClasesModel guardar(ClasesModel clase) {
        return repo.save(clase);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
