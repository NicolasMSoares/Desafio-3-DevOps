package br.com.cwi.api.service;


import br.com.cwi.api.factories.UsuarioFactory;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioESiProprioService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioExisteService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioJaEstaNaListaSolicitacaoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioNaoEAmigoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SolicitarAmizadeServiceTest {

    @InjectMocks
    private SolicitarAmizadeService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private ValidarUsuarioNaoEAmigoService validarUsuarioNaoEAmigoService;

    @Mock
    private ValidarUsuarioESiProprioService validarUsuarioESiProprioService;

    @Mock
    private ValidarUsuarioJaEstaNaListaSolicitacaoService validarUsuarioJaEstaNaListaSolicitacaoService;

    @Mock
    private ValidarUsuarioExisteService validarUsuarioExisteService;

    @Test
    @DisplayName("Deve enviar uma solicitacao de amizade")
    void deveEnviarSolicitacao() {

        Usuario usuario = UsuarioFactory.get();
        Usuario amigo = UsuarioFactory.get();
        Long amigoId = amigo.getId();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(usuarioRepository.findById(amigoId)).thenReturn(Optional.of(amigo));

        tested.solicitarAmizade(amigoId);

        verify(validarUsuarioExisteService).validar(amigoId);
        verify(usuarioAutenticadoService).get();
        verify(validarUsuarioESiProprioService).validar(usuario.getId(), amigoId);
        verify(validarUsuarioNaoEAmigoService).validar(usuario.getListaAmigos(), amigoId);
        verify(validarUsuarioJaEstaNaListaSolicitacaoService).validar(usuario.getSolicitacao(), amigoId);
        verify(usuarioRepository).save(usuario);

        assertEquals(usuario.getSolicitacao().get(0).getId(), amigoId);

    }
}
