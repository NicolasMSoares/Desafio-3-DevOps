package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CriarPostagemRequest {

    @NotBlank(message = "Deve inserir uma imagem")
    private String imagemPost;
    @NotBlank(message = "Deve inserir uma descricao")
    private String descricao;
    @NotBlank(message = "Deve inserir o jogo")
    private String jogo;
}
