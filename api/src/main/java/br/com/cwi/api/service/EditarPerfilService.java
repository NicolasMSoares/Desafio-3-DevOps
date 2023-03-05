package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.EditarPerfilRequest;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarPerfilService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public void editarPerfil(EditarPerfilRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setApelido(request.getApelido());
        usuario.setImagemPerfil(request.getImagemPerfil());


        usuarioRepository.save(usuario);

    }
}
