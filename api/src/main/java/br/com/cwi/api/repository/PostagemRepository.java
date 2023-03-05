package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    @Query(value = "select p from Postagem p where p.id in (select post1.id from Postagem post1 join Usuario u on u.id = post1.usuario where u.id = :id) or p.id in (select post2.id from Postagem post2 where post2.usuario in (:listaAmigos)) order by p.dataPostagem desc")
    List<Postagem> findAllPostagensPorOrdemDeData(@Param("id") Long id, @Param("listaAmigos") List<Usuario> listaAmigos);
}
