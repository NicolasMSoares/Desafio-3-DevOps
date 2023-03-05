package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.validacoes.ValidarSolicitacaoJaFoiEnviadaService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioExisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejeitarSolicitacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ValidarUsuarioExisteService validarUsuarioExisteService;

    @Autowired
    private ValidarSolicitacaoJaFoiEnviadaService validarSolicitacaoJaFoiEnviadaService;

    public void rejeitarSolicitacao(Long id) {

        validarUsuarioExisteService.validar(id);

        Usuario usuario = usuarioAutenticadoService.get();

        Usuario amigo = usuarioRepository.findById(id).get();

        validarSolicitacaoJaFoiEnviadaService.validar(usuario.getSolicitacao(), id);

        usuario.getSolicitacao().remove(amigo);

        usuarioRepository.save(usuario);
    }
}
