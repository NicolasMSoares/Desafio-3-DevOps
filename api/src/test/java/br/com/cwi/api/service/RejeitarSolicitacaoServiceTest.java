package br.com.cwi.api.service;

import br.com.cwi.api.factories.UsuarioFactory;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.validacoes.ValidarSolicitacaoJaFoiEnviadaService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioExisteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RejeitarSolicitacaoServiceTest {

    @InjectMocks
    private RejeitarSolicitacaoService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private ValidarUsuarioExisteService validarUsuarioExisteService;

    @Mock
    private ValidarSolicitacaoJaFoiEnviadaService validarSolicitacaoJaFoiEnviadaService;


    @Test
    @DisplayName("Deve rejeitar solicitacao de amizade")
    void deveRejeitarSolicitacao() {

        Usuario usuario = UsuarioFactory.get();
        Usuario amigo = UsuarioFactory.get();
        Long amigoId = amigo.getId();
        usuario.getSolicitacao().add(amigo);

        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(usuarioRepository.findById(amigoId)).thenReturn(Optional.of(amigo));

        tested.rejeitarSolicitacao(amigoId);

        verify(validarSolicitacaoJaFoiEnviadaService).validar(usuario.getSolicitacao(), amigoId);
        verify(validarUsuarioExisteService).validar(amigoId);
        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).findById(amigoId);
        verify(usuarioRepository).save(usuario);

        assertTrue(usuario.getSolicitacao().isEmpty());
    }
}
