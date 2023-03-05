package br.com.cwi.api.service;

import br.com.cwi.api.factories.UsuarioFactory;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.validacoes.ValidarUsuarioEAmigoService;
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
public class DesfazerAmizadeServiceTest {

    @InjectMocks
    private DesfazerAmizadeService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ValidarUsuarioExisteService validarUsuarioExisteService;

    @Mock
    private ValidarUsuarioEAmigoService validarUsuarioEAmigoService;

    @Test
    @DisplayName("Deve desfazer amizade com usuario removendo da lista de amigos")
    void deveDesfazerAmizade() {

        Usuario usuario = UsuarioFactory.get();
        Usuario amigo = UsuarioFactory.get();

        Long amigoId = amigo.getId();
        usuario.getListaAmigos().add(amigo);

        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(usuarioRepository.findById(amigoId)).thenReturn(Optional.of(amigo));

        tested.desfazerAmizade(amigoId);

        verify(validarUsuarioExisteService).validar(amigoId);
        verify(usuarioAutenticadoService).get();
        verify(validarUsuarioEAmigoService).validar(usuario.getListaAmigos(), amigoId);
        verify(usuarioRepository).save(usuario);

        assertTrue(usuario.getListaAmigos().isEmpty());
    }
}
