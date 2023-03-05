package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.CriarPostagemRequest;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.factories.UsuarioFactory;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.NowService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CriarPostagemServiceTest {

    @InjectMocks
    private CriarPostagemService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private PostagemRepository postagemRepository;

    @Mock
    private NowService nowService;

    @Captor
    private ArgumentCaptor<Postagem> PostCaptor;

    @Test
    @DisplayName("Deve criar nova postagem")
    void deveCriarPostagem() {

        Usuario usuario = UsuarioFactory.get();

        CriarPostagemRequest request = new CriarPostagemRequest();
        request.setImagemPost("Imagem Teste");
        request.setDescricao("Novo Item teste");
        request.setJogo("Teste Jogo");

        LocalDateTime hoje = LocalDateTime.now();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(nowService.getDate()).thenReturn(hoje);

        tested.postar(request);

        verify(postagemRepository).save(PostCaptor.capture());

        Postagem postagem = PostCaptor.getValue();
        assertEquals(hoje, postagem.getDataPostagem());
        assertEquals(usuario, postagem.getUsuario());

    }

}
