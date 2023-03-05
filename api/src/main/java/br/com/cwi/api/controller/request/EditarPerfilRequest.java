package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditarPerfilRequest {

    @NotBlank(message = "Deve inserir o nome completo")
    private String nomeCompleto;

    @NotBlank(message = "Deve inserir o apelido")
    private String apelido;

    @NotBlank(message = "Deve inserir uma imagem")
    private String imagemPerfil;
}
