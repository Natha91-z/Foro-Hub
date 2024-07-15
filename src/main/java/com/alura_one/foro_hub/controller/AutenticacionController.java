package com.alura_one.foro_hub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.JMXAuthenticator;

@RestController
@RequestMapping("/ login")
public class AuthenticacionController {
    @Autowired
    private AuthenticacionController autenticacionController;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public <DatosAutenticacionUsuario, Usuario> ResponseEntity autenticaUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario, JMXAuthenticator authenticationManager){
        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var JwTtoken = tokenService.verifyToken((String) usuarioAutenticado.getPrincipals());
        return ResponseEntity.ok(new DatosAutenticacionUsuario(JwTtoken));


    }
}
