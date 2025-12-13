package com.rollerspeed.v1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El correo es obligatorio")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "El nivel es obligatorio")
    @Column(nullable = false, length = 50)
    private String nivel;

    @NotBlank(message = "El área de aprendizaje es obligatoria")
    @Column(name = "aprendiz_en", nullable = false, length = 50)
    private String aprendizEn;
}