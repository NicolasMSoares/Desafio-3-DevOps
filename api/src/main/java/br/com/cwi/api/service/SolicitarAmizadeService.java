package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioESiProprioService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioExisteService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioNaoEAmigoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioJaEstaNaListaSolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitarAmizadeService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ValidarUsuarioNaoEAmigoService validarUsuarioNaoEAmigoService;

    @Autowired
    private ValidarUsuarioESiProprioService validarUsuarioESiProprioService;

    @Autowired
    private ValidarUsuarioJaEstaNaListaSolicitacaoService validarUsuarioJaEstaNaListaSolicitacaoService;

    @Autowired
    private ValidarUsuarioExisteService validarUsuarioExisteService;

    public void solicitarAmizade(Long id) {

        validarUsuarioExisteService.validar(id);

        Usuario usuario = usuarioAutenticadoService.get();

        validarUsuarioESiProprioService.validar(usuario.getId(), id);
        validarUsuarioNaoEAmigoService.validar(usuario.getListaAmigos(), id);
        validarUsuarioJaEstaNaListaSolicitacaoService.validar(usuario.getSolicitacao(), id);

        Usuario amigo = usuarioRepository.findById(id).get();

        usuario.getSolicitacao().add(amigo);

        usuarioRepository.save(usuario);


    }
}
