package com.rollerspeed.v1.controller;

import com.rollerspeed.v1.Model.EstudianteModel;
import com.rollerspeed.v1.Model.InstructoresModel;
import com.rollerspeed.v1.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Administración de Instructores", description = "Manejo de Instructores")

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
     @Operation (
        summary = "Obtener todas los Intructores registrados",
        description = "Devuelve los instructores registrados.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de instructores obtenida correctamente",
                content = @Content(schema = @Schema(implementation = EstudianteModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )

    @GetMapping("/listadoinstructores")
    public String listar(Model model) {
        model.addAttribute("instructores", service.listar());
        return "home/listadoinstructores";
    }
    
    @Operation(
        summary = "Editar instructor",
        description = "Permite editar el instructor seleccionado",
        responses = {
            @ApiResponse(responseCode = "200", description = "Instructor editdo correctamente",
                content = @Content(schema = @Schema(implementation = InstructoresModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    ) 
    @GetMapping("/editarInstructor/{id}")
    public String editar(@PathVariable Long id, Model model) {
        service.obtenerPorId(id).ifPresent(i -> model.addAttribute("instructor", i));
        return "home/instructores";
    }
     @Operation(
    summary = "Elimina un instructor de la lista ",
    description = "Indicar el ID del instructor que se desea eliminar.",
    responses = {
        @ApiResponse(responseCode = "200", description = "Instructor eliminado correctamente",
            content = @Content(schema = @Schema(implementation = InstructoresModel.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    }
)
    @GetMapping("/eliminarInstructor/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/index/listadoinstructores";
    }
}