package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.BuscarContatoResponse;
import br.com.cwi.api.mapper.BuscarContatoMapper;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarContadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<BuscarContatoResponse> buscarUsuario(String text, Pageable pageable) {

        return usuarioRepository.findByNomeCompletoContainingIgnoreCaseOrEmailContainingIgnoreCase(text, pageable)
                .map(BuscarContatoMapper::toResponse);
    }


}
