package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioEAmigoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioExisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesfazerAmizadeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidarUsuarioExisteService validarUsuarioExisteService;

    @Autowired
    private ValidarUsuarioEAmigoService validarUsuarioEAmigoService;


    public void desfazerAmizade(Long id) {

        validarUsuarioExisteService.validar(id);

        Usuario usuario = usuarioAutenticadoService.get();

        validarUsuarioEAmigoService.validar(usuario.getListaAmigos(), id);


        Usuario amigo = usuarioRepository.findById(id).get();

        usuario.getListaAmigos().remove(amigo);

        usuarioRepository.save(usuario);
    }
}
