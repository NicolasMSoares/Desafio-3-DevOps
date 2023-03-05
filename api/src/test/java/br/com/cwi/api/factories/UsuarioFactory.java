package br.com.cwi.api.factories;

import br.com.cwi.api.security.domain.Usuario;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get() {
        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNomeCompleto("Usuário de teste");
        usuario.setEmail("teste@cwi.com.br");
        usuario.setApelido("Teste");
        usuario.setDataNascimento(LocalDate.of(2000,03,03));
        usuario.setSenha("1234");
        usuario.setImagemPerfil("FotoPerfil");
        return usuario;
    }
}
