package br.com.cwi.api.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListaAmigosResponse {

    private Long id;

    private String nomeCompleto;


}
