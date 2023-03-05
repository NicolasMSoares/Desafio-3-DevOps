package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.CriarPostagemRequest;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.mapper.CriarPostagemMapper.toEntity;

@Service
public class CriarPostagemService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private NowService nowService;

    public void postar(CriarPostagemRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        Postagem postagem = toEntity(request);

        postagem.setDataPostagem(nowService.getDate());
        postagem.setUsuario(usuario);

        postagemRepository.save(postagem);

    }
}
