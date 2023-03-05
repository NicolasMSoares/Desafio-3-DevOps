package br.com.cwi.api.service.validacoes;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarUsuarioESiProprioService {


    public void validar(Long idUsuario, Long idSolicitacao){
        if(idUsuario == idSolicitacao){
            throw new ResponseStatusException(BAD_REQUEST, "Não é possível fazer uma solicitacao para si próprio.");
        }
    }
}
