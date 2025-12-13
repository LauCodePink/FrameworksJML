package com.rollerspeed.v1.controller;

import com.rollerspeed.v1.Model.EstudianteModel;
import com.rollerspeed.v1.service.EstudianteService;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping("/estudiantes")
    public String formulario(Model model) {
        model.addAttribute("estudiante", new EstudianteModel());
        return "home/estudiantes";
    }

    @PostMapping("/estudiantes")
    public String guardar(@ModelAttribute EstudianteModel estudiante) {
        service.guardar(estudiante);
        return "redirect:/index/listadoestudiantes";
    }

    @GetMapping("/listadoestudiantes")
    public String listar(Model model) {
        model.addAttribute("estudiantes", service.listar());
        return "home/listadoestudiantes";
    }

    @GetMapping("/editarEstudiante/{id}")
    public String editar(@PathVariable Long id, Model model) {
        service.obtenerPorId(id).ifPresent(e -> model.addAttribute("estudiante", e));
        return "home/estudiantes";
    }

    @GetMapping("/eliminarEstudiante/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/index/listadoestudiantes";
    }
}