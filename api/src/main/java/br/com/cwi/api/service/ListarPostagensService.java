package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.ListarPostagensResponse;
import br.com.cwi.api.mapper.CriarPostagemMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPostagensService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<ListarPostagensResponse> listarPostagens() {

        Usuario usuario = usuarioAutenticadoService.get();

        List<Usuario> listaAmigos = usuario.getListaAmigos();

        return postagemRepository.findAllPostagensPorOrdemDeData(usuario.getId(), listaAmigos).stream()
                .map(CriarPostagemMapper::toResponse)
                .collect(Collectors.toList());
    }
}
