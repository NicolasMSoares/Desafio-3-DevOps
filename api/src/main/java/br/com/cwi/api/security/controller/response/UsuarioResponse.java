package br.com.cwi.api.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponse {

    private String nomeCompleto;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private String imagemPerfil;
    private List<String> permissoes;
}
