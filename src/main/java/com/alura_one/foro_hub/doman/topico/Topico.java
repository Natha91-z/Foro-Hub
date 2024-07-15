package com.alura_one.foro_hub.doman.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String autor;
    private  String mensaje;
    private  String curso;
    private  String titulo;
    @Enumerated(EnumType.STRING)
    private Estado status;
    private localDateTime fechaCreacion;

    public Topico(DatoListadoTopico datoListadoTopico){
        this.autor = DatosRegistroTopico.autor();
        this.mensaje = DatosRegistroTopico.mensaje();
        this.curso = datoListadoTopico.nombreCurso();
        this.titulo = datoListadoTopico.titulo();
        this.fechaCreacion = datoListadoTopico.fechadeCreacion();
    }

    public void actualizarTopico(DatoListadoTopico datoListadoTopico){
        this.autor = actualizarTopico().autor();
        this.mensaje = actualizarTopico().mensaje();
        this.curso = actualizarTopico().nombreCurso();
        this.titulo = actualizarTopico().titulo();
        this.status = actualizarTopico(). estatus();
        this.fechaCreacion = actualizarTopico().fechaCreacion();

    }
}
