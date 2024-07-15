package com.alura_one.foro_hub.doman.topico;

public class DatoRespuesta  (
        Long id,
        String autor,
        String mensaje,
        String curso,
        String titulo,
        String estado,
        String fechaCreacion
){
    public DatoListadoTopico(Topico topico){
        this(topico.getId(), topico.getAutor(),topico.getMensaje(), topico.getCurso(),topico.getTitulo(),topico.getStatus().toString(),topico.getFechaCreacion().toString());

    }
}
