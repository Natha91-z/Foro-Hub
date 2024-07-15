package com.alura_one.foro_hub.doman.topico;

public class DatoListadoTopico (
        long id,
        String tutilo,
        String mensaje,
        String fechaCreacion,
        Estado estado,
        String autor,
        String curso
){
    public DatoListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getfechaCreacion().tosString(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
