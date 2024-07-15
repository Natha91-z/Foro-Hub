package com.alura_one.foro_hub.doman.topico;

import com.alura_one.foro_hub.controller.Estado;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public record DatosRegistroTopico (
        @NotBlank
        String autor,
        @NotBlank
        String mensaje,
        @NotBlank
        String nombreCurso,
        @NotBlank
        String titulo,
        @NotNull
        Estado estado
) {
}
