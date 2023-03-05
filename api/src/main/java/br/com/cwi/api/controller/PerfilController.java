package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.CriarPostagemRequest;
import br.com.cwi.api.controller.request.EditarPerfilRequest;
import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.controller.response.BuscarContatoResponse;
import br.com.cwi.api.controller.response.ListarPostagensResponse;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private SolicitacoesAmizadeService solicitacoesAmizadeService;

    @Autowired
    private CriarPostagemService criarPostagemService;

    @Autowired
    private SolicitarAmizadeService solicitarAmizadeService;

    @Autowired
    private AdicionarAmigoService adicionarAmigoService;

    @Autowired
    private RejeitarSolicitacaoService rejeitarSolicitacaoService;

    @Autowired
    private ListarPostagensService listarPostagensService;

    @Autowired
    private ListarAmigosService listarAmigosService;

    @Autowired
    private BuscarContadoService buscarUsuarioService;

    @Autowired
    private DesfazerAmizadeService desfazerAmizadeService;

    @Autowired
    private EditarPerfilService editarPerfilService;



    @GetMapping("/solicitacoes")
    public List<AmizadeResponse> listarSolicitacoes() {
        return solicitacoesAmizadeService.listarSolicitacoes();
    }

    @PutMapping("/{id}/solicitar-amizade")
    @ResponseStatus(OK)
    public void solicitarAmizade(@PathVariable Long id) {
        solicitarAmizadeService.solicitarAmizade(id);
    }

    @PutMapping("/{id}/adicionar-amigo")
    @ResponseStatus(OK)
    public void adicionarAmigo(@PathVariable Long id) {
        adicionarAmigoService.adicionarAmigo(id);
    }

    @PutMapping("/{id}/rejeitar-solicitacao")
    @ResponseStatus(OK)
    public void rejeitarSolicitacao(@PathVariable Long id) {
        rejeitarSolicitacaoService.rejeitarSolicitacao(id);
    }

    @GetMapping("/buscar-contato")
    public Page<BuscarContatoResponse> buscarUsuario(@RequestParam String text, Pageable pageable) {
        return buscarUsuarioService.buscarUsuario(text, pageable);
    }


    @GetMapping("/lista-amigos")
    public Page<AmizadeResponse> listarAmigos(@RequestParam String text, Pageable pageable) {
        return listarAmigosService.listarAmigos(text, pageable);
    }

    @PutMapping("/{id}/desfazer-amizade")
    @ResponseStatus(NO_CONTENT)
    public void desfazerAmizade(@PathVariable Long id) {
        desfazerAmizadeService.desfazerAmizade(id);
    }


    @PostMapping("/postagem")
    @ResponseStatus(CREATED)
    public void criarPostagem(@Valid @RequestBody CriarPostagemRequest request) {
        criarPostagemService.postar(request);
    }

    @GetMapping("/listar-postagens")
    public List<ListarPostagensResponse> listarPostagens() {
        return listarPostagensService.listarPostagens();
    }

    @PutMapping("/editar-perfil")
    @ResponseStatus(OK)
    public void editarPerfil(@Valid @RequestBody EditarPerfilRequest request) {
        editarPerfilService.editarPerfil(request);
    }

}
