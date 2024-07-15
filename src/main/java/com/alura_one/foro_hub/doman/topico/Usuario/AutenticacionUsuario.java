package com.alura_one.foro_hub.doman.topico.Usuario;

import jakarta.validation.constraints.NotBlank;

public record AutenticacionUsuario (
        @NotBlank
        String login,
        @NotBlank
        String clave
){
}
