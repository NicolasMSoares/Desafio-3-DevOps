package br.com.cwi.api.security.repository;

import br.com.cwi.api.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    @Query(value = "select u.listaAmigos from Usuario u where u.id = :id and u.nomeCompleto like %:text% or u.email like %:text%")
    Page<Usuario> findByNomeCompletoContainingIgnoreCaseOrEmailContainingIgnoreCase(@Param("text") String text, @Param("id") Long id, Pageable pageable);

    @Query(value = "select u from Usuario u where u.nomeCompleto like %:text% or u.email like %:text%")
    Page<Usuario> findByNomeCompletoContainingIgnoreCaseOrEmailContainingIgnoreCase(@Param("text") String text, Pageable pageable);



}
