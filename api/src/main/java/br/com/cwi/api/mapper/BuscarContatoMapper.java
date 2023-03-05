package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.BuscarContatoResponse;
import br.com.cwi.api.security.domain.Usuario;

public class BuscarContatoMapper {

    public static BuscarContatoResponse toResponse(Usuario entity) {

        return BuscarContatoResponse.builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .apelido(entity.getApelido())
                .imagemPerfil(entity.getImagemPerfil())
                .build();
    }
}
