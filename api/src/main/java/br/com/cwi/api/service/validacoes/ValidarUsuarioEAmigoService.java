package br.com.cwi.api.service.validacoes;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarUsuarioEAmigoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(List<Usuario> listaAmigos, Long id) {

        Usuario usuario = usuarioRepository.findById(id).get();

        if(!listaAmigos.contains(usuario)) {
            throw new ResponseStatusException(BAD_REQUEST, "Esse usuario não esta na sua lista de amigos");
        }

    }
}
