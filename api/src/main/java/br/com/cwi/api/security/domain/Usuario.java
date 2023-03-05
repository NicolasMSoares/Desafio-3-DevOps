package br.com.cwi.api.security.domain;

import br.com.cwi.api.domain.Postagem;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private String senha;
    private String imagemPerfil;
    private boolean ativo;

    @ManyToMany
    @JoinTable(name = "solicitacao_amizade",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "amigo_id"))
    private List<Usuario> solicitacao = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "lista_amigos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "amigo_id"))
    private List<Usuario> listaAmigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }
}
