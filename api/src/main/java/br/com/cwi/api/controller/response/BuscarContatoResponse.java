package br.com.cwi.api.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarContatoResponse {

    private Long id;

    private String nomeCompleto;

    private String email;

    private String apelido;

    private String imagemPerfil;
}
