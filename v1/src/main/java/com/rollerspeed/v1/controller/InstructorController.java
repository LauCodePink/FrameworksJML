package com.rollerspeed.v1.controller;

import com.rollerspeed.v1.Model.InstructoresModel;
import com.rollerspeed.v1.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping("/instructores")
    public String formulario(Model model) {
        model.addAttribute("instructor", new InstructoresModel());
        return "home/instructores";
    }

    @PostMapping("/instructores")
    public String guardar(@ModelAttribute InstructoresModel instructor) {
        service.guardar(instructor);
        return "redirect:/index/listadoinstructores";
    }

    @GetMapping("/listadoinstructores")
    public String listar(Model model) {
        model.addAttribute("instructores", service.listar());
        return "home/listadoinstructores";
    }

    @GetMapping("/editarInstructor/{id}")
    public String editar(@PathVariable Long id, Model model) {
        service.obtenerPorId(id).ifPresent(i -> model.addAttribute("instructor", i));
        return "home/instructores";
    }

    @GetMapping("/eliminarInstructor/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/index/listadoinstructores";
    }
}