package br.com.cwi.api.service.validacoes;

import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarUsuarioExisteService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void validar(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(BAD_REQUEST, "Este usuário não existe.");
        }
    }
}
