package com.alura_one.foro_hub.controller;


import com.alura_one.foro_hub.doman.topico.DatosRegistroTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping
public class TopicoController {
    @Autowired
    TopicoRepository topicoRespository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar(@PageableDefault (page=0, size=10, sort = {"fechaCreacion"})Pageable paginacion){
        return ResponseEntity.ok(TopicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }
    @GetMapping("/id")
    @Transactional
    public ResponseEntity<DatosListadoTopico> listadoTopicoPorId(@PathVariable long id){
        Optional<Topico> topicoEncontrado = Optional.of(topicoRespository.getReferenceById(id));
        if (topicoEncontrado.isPresent()){
            return ResponseEntity.ok(new DatosListadoTopico(topicoEncontrado.get()));
        }
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRespository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico);

        URI url = uriComponentsBuilder. path("topicos/id").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.accepted(url).body(datosRegistroTopico);
    }

    @PutMapping("/id")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico){
        Optiona<Topico> topicoBuscado = Optional.of(topicoRespository.getReferenceById(id));
        if (topicoBuscado.isPresent()){
            Topico TopicoEncontrado = topicoBuscado.get();
            topicoEncontrado.actualizarTopico(datosActualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaTopico(topicoEncontrado));
        }
    }
    @DeleteMapping("/id")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> topicoBuscado = Optional.of(topicoRespository.getReferenceById(id));
        if (topicoBuscado.isPresent()){
            topicoRespository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

}
