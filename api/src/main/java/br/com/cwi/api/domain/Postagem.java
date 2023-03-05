package br.com.cwi.api.domain;

import br.com.cwi.api.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String imagemPost;
    private String descricao;
    private String jogo;
    private LocalDateTime dataPostagem;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
