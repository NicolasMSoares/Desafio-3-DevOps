package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.EditarPerfilRequest;
import br.com.cwi.api.factories.UsuarioFactory;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarPerfilServiceTest {

    @InjectMocks
    private EditarPerfilService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;


    @Test
    @DisplayName("Deve editar perfil do usuario")
    void deveEditarPerfil() {

        Usuario usuario = UsuarioFactory.get();

        EditarPerfilRequest request = new EditarPerfilRequest();
        request.setNomeCompleto("Nicolas Teste");
        request.setApelido("Nicolas");
        request.setImagemPerfil("Nova Foto Teste");

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        tested.editarPerfil(request);

        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).save(usuario);

        assertEquals("Nicolas Teste", usuario.getNomeCompleto());
    }
}
