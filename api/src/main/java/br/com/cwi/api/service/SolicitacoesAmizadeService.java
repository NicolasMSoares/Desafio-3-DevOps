package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.mapper.AmizadeMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SolicitacoesAmizadeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<AmizadeResponse> listarSolicitacoes() {

        Usuario usuario = usuarioAutenticadoService.get();


        return usuario.getSolicitacao().stream()
                .map(AmizadeMapper::toResponse)
                .collect(toList());
    }
}
