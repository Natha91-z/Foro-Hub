package com.alura_one.foro_hub.doman.topico.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
