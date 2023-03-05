package br.com.cwi.api.service.validacoes;

import br.com.cwi.api.factories.UsuarioFactory;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidarSolicitacaoJaFoiEnviadaServiceTest {


    @InjectMocks
    private ValidarSolicitacaoJaFoiEnviadaService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve fazer nada quando houver solicitacao")
    void deveFazerNadaSemSolicitacao() {

        Usuario usuario = UsuarioFactory.get();
        Usuario amigo = UsuarioFactory.get();
        Long amigoId = amigo.getId();

        usuario.getSolicitacao().add(amigo);

        when(usuarioRepository.findById(amigoId)).thenReturn(Optional.of(amigo));

        tested.validar(usuario.getSolicitacao(), amigoId);

        verify(usuarioRepository).findById(amigoId);
    }

}
