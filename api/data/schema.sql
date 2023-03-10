DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS solicitacao_amizade CASCADE;
DROP TABLE IF EXISTS lista_amigos CASCADE;
DROP TABLE IF EXISTS postagem CASCADE;
DROP TABLE IF EXISTS curtidas CASCADE;
DROP TABLE IF EXISTS comentarios CASCADE;


CREATE TABLE usuario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome_completo VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	apelido VARCHAR(50),
	data_nascimento DATE NOT NULL,
	senha VARCHAR(100) NOT NULL,
	imagem_perfil VARCHAR(512),
	ativo BOOLEAN NOT NULL
);
ALTER TABLE usuario ADD CONSTRAINT pk_usuario PRIMARY KEY (id);
ALTER TABLE usuario ADD CONSTRAINT uk_usuario_email UNIQUE (email);


CREATE TABLE permissao (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome VARCHAR(100) NOT NULL,
	usuario_id BIGINT NOT NULL
);
ALTER TABLE permissao ADD CONSTRAINT pk_permissao PRIMARY KEY (id);
ALTER TABLE permissao ADD CONSTRAINT uk_permissao UNIQUE (nome, usuario_id);
ALTER TABLE permissao ADD CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;


CREATE TABLE solicitacao_amizade (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    usuario_id BIGINT NOT NULL,
    amigo_id BIGINT NOT NULL
);

ALTER TABLE solicitacao_amizade ADD CONSTRAINT pk_solicitacao_amizade PRIMARY KEY (id);
ALTER TABLE solicitacao_amizade ADD CONSTRAINT fk_solicitacao_amizade_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE solicitacao_amizade ADD CONSTRAINT fk_solicitacao_amizade_amigo_id FOREIGN KEY (amigo_id) REFERENCES usuario;


CREATE TABLE lista_amigos (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    usuario_id BIGINT NOT NULL,
    amigo_id BIGINT NOT NULL
);

ALTER TABLE lista_amigos ADD CONSTRAINT pk_lista_amigos PRIMARY KEY (id);
ALTER TABLE lista_amigos ADD CONSTRAINT fk_lista_amigos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE lista_amigos ADD CONSTRAINT fk_lista_amigos_amigo_id FOREIGN KEY (amigo_id) REFERENCES usuario;

CREATE TABLE postagem (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    imagem_post VARCHAR(512) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    jogo VARCHAR(100) NOT NULL,
    data_postagem TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL
);

ALTER TABLE postagem ADD CONSTRAINT pk_postagem PRIMARY KEY (id);
ALTER TABLE postagem ADD CONSTRAINT fk_postagem_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario;


CREATE TABLE curtidas (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    postagem_id BIGINT NOT NULL,
    usuario_curtiu_id BIGINT NOT NULL
);
ALTER TABLE curtidas ADD CONSTRAINT pk_curtidas PRIMARY KEY (id);
ALTER TABLE curtidas ADD CONSTRAINT fk_curtidas_postagem_id FOREIGN KEY (postagem_id) REFERENCES postagem;
ALTER TABLE curtidas ADD CONSTRAINT fk_curtidas_usuario_curtiu_id FOREIGN KEY (usuario_curtiu_id) REFERENCES postagem;


CREATE TABLE comentarios (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    postagem_id BIGINT NOT NULL,
    usuario_comentou_id BIGINT NOT NULL,
    comentario VARCHAR(255) NOT NULL
);
ALTER TABLE comentarios ADD CONSTRAINT pk_comentarios PRIMARY KEY (id);
ALTER TABLE comentarios ADD CONSTRAINT fk_comentarios_postagem_id FOREIGN KEY (postagem_id) REFERENCES postagem;
ALTER TABLE comentarios ADD CONSTRAINT fk_comentarios_usuario_comentou_id FOREIGN KEY (usuario_comentou_id) REFERENCES postagem;

