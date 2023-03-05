package br.com.cwi.api.security.mapper;

import br.com.cwi.api.security.controller.request.UsuarioRequest;
import br.com.cwi.api.security.controller.response.UsuarioResponse;
import br.com.cwi.api.security.domain.Permissao;
import br.com.cwi.api.security.domain.Usuario;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setEmail(request.getEmail());
        entity.setApelido(request.getApelido());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setImagemPerfil(request.getImagemPerfil());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .nomeCompleto(entity.getNomeCompleto())
                .email(entity.getEmail())
                .apelido(entity.getApelido())
                .dataNascimento(entity.getDataNascimento())
                .imagemPerfil(entity.getImagemPerfil())
                .permissoes(buildPermissoesResponse(entity.getPermissoes()))
                .build();
    }

    private static List<String> buildPermissoesResponse(List<Permissao> permissoes) {
        return permissoes.stream()
                .map(Permissao::getNome)
                .collect(toList());
    }
}
