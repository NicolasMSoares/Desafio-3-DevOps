package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.CriarPostagemRequest;
import br.com.cwi.api.controller.response.ListarPostagensResponse;
import br.com.cwi.api.domain.Postagem;

public class CriarPostagemMapper {
    public static Postagem toEntity(CriarPostagemRequest request) {
        return Postagem.builder()
                .imagemPost(request.getImagemPost())
                .descricao(request.getDescricao())
                .jogo(request.getJogo())
                .build();
    }

    public static ListarPostagensResponse toResponse(Postagem entity) {
        return ListarPostagensResponse.builder()
                .imagemPost(entity.getImagemPost())
                .descricao(entity.getDescricao())
                .jogo(entity.getJogo())
                .dataPostagem(entity.getDataPostagem())
                .build();

    }
}
