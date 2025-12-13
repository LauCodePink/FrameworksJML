package com.rollerspeed.v1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_clases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre de la clase es obligatorio")
    @Column(nullable = false)
    private String nombreClase;

    @NotBlank(message = "Nivel requerido")
    @Column(nullable = false)
    private String nivel; // principiante, intermedio, avanzado

    @NotBlank(message = "Día de la semana es obligatorio")
    @Column(name = "dia_semana", nullable = false)
    private String diaSemana;

    @NotBlank(message = "Hora de inicio requerida")
    @Column(name = "hora_inicio", nullable = false)
    private String horaInicio;

    @NotBlank(message = "Hora de fin requerida")
    @Column(name = "hora_fin", nullable = false)
    private String horaFin;

    @NotBlank(message = "Instructor requerido")
    @Column(name = "instructor_nombre", nullable = false)
    private String instructorNombre; // Para simplicidad (puedes usar relación @ManyToOne después)

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}
