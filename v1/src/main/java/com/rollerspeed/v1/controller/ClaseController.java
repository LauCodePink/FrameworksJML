package com.rollerspeed.v1.controller;

import com.rollerspeed.v1.Model.ClasesModel;
import com.rollerspeed.v1.Model.EstudianteModel;
import com.rollerspeed.v1.Model.InstructoresModel;
import com.rollerspeed.v1.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Administración de clases", description = "Operaciones sobre el manejo de las clases")

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

     @Operation (
        summary = "Obtener todas las clases registradas",
        description = "Devuelve la lista de clases registradas.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de clases obtenida correctamente",
                content = @Content(schema = @Schema(implementation = EstudianteModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )


    @GetMapping("/calendarioclases")
    public String listar(Model model) {
        model.addAttribute("clases", service.listar());
        return "home/calendarioclases";
    }
     @Operation(
        summary = "Editar clase",
        description = "Permite editar las clases seleccionadas",
        responses = {
            @ApiResponse(responseCode = "200", description = "Clase editda correctamente",
                content = @Content(schema = @Schema(implementation = InstructoresModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    ) 

    @GetMapping("/editarClase/{id}")
    public String editar(@PathVariable Long id, Model model) {
        service.obtenerPorId(id).ifPresent(c -> model.addAttribute("clase", c));
        return "home/clases";
    }

    @Operation(
        summary = "Eliminar una clase",
        description = "Permite eliminar una clase registrada",
        responses = {
            @ApiResponse(responseCode = "200", description = "Clase eliminada correctamente. ",
                content = @Content(schema = @Schema(implementation = EstudianteModel.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )

    @GetMapping("/eliminarClase/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/index/calendarioclases";
    }
}