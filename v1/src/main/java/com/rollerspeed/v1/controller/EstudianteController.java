package com.rollerspeed.v1.controller;

import com.rollerspeed.v1.Model.EstudianteModel;
import com.rollerspeed.v1.service.EstudianteService;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Administracion de estudiantes", description = "Operaciones sobre el manejo de Estudiantes")

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
    
     @Operation (
        summary = "Obtener todas los estudiantes registrados",
        description = "Devuelve la lista de estudiantes registrados.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida correctamente",
                content = @Content(schema = @Schema(implementation = EstudianteModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )

    @GetMapping("/listadoestudiantes")
    public String listar(Model model) {
        model.addAttribute("estudiantes", service.listar());
        return "home/listadoestudiantes";
    }
      @Operation(
        summary = "Editar un estudiante",
        description = "Permite editar un estudiante registrado. ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Estudiante editado corectamente. ",
                content = @Content(schema = @Schema(implementation = EstudianteModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )

    @GetMapping("/editarEstudiante/{id}")
    public String editar(@PathVariable Long id, Model model) {
        service.obtenerPorId(id).ifPresent(e -> model.addAttribute("estudiante", e));
        return "home/estudiantes";
    }

     @Operation(
        summary = "Eliminar un estudiante",
        description = "Permite eliminar un estudiante registrado",
        responses = {
            @ApiResponse(responseCode = "200", description = "Estudiante eliminado correctamente. ",
                content = @Content(schema = @Schema(implementation = EstudianteModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )

    @GetMapping("/eliminarEstudiante/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/index/listadoestudiantes";
    }
}