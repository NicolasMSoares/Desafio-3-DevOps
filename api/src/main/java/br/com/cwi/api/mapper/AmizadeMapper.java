package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.AmizadeResponse;
import br.com.cwi.api.security.domain.Usuario;

public class AmizadeMapper {

    public static AmizadeResponse toResponse(Usuario entity) {

        return AmizadeResponse.builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .apelido(entity.getApelido())
                .imagemPerfil(entity.getImagemPerfil())
                .build();
    }
}
