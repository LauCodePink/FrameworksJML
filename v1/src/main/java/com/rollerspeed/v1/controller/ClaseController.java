package com.rollerspeed.v1.controller;

import com.rollerspeed.v1.Model.ClasesModel;
import com.rollerspeed.v1.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class ClaseController {

    @Autowired
    private ClaseService service;

    @GetMapping("/clases")
    public String formulario(Model model) {
        model.addAttribute("clase", new ClasesModel());
        return "home/clases";
    }

    @PostMapping("/clases")
    public String guardar(@ModelAttribute ClasesModel clase) {
        service.guardar(clase);
        return "redirect:/index/calendarioclases";
    }

    @GetMapping("/calendarioclases")
    public String listar(Model model) {
        model.addAttribute("clases", service.listar());
        return "home/calendarioclases";
    }

    @GetMapping("/editarClase/{id}")
    public String editar(@PathVariable Long id, Model model) {
        service.obtenerPorId(id).ifPresent(c -> model.addAttribute("clase", c));
        return "home/clases";
    }

    @GetMapping("/eliminarClase/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/index/calendarioclases";
    }
}