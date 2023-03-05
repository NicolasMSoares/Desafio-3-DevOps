package br.com.cwi.api.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListarPostagensResponse {


    private String imagemPost;
    private String descricao;
    private String jogo;
    private LocalDateTime dataPostagem;
}
