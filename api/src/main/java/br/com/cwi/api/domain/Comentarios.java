package br.com.cwi.api.domain;

import br.com.cwi.api.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comentarios {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "usuario_comentou_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;
}
