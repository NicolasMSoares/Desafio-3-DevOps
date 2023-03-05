package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.mapper.AmizadeMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAmigosService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<AmizadeResponse> listarAmigos(String text, Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        return usuarioRepository.findByNomeCompletoContainingIgnoreCaseOrEmailContainingIgnoreCase(text, usuario.getId(), pageable)
                .map(AmizadeMapper::toResponse);
    }
}
