insert into usuario (email, nome_completo, apelido, imagem_perfil, data_nascimento, senha, ativo) values ('nicolas@cwi.com.br', 'Nicolas Soares', 'Nicolas', 'https://upload.wikimedia.org/wikipedia/commons/6/6a/HIRES-AVATAR-AJB.jpg?uselang=pt-br', to_date('2000-03-26', 'YYYY-MM-DD'), '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);
insert into usuario (email, nome_completo, apelido, imagem_perfil, data_nascimento, senha, ativo) values ('joao@cwi.com.br', 'Joao Silva', 'Joao', 'https://upload.wikimedia.org/wikipedia/commons/6/6a/HIRES-AVATAR-AJB.jpg?uselang=pt-br', to_date('1999-08-27', 'YYYY-MM-DD'), '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);
insert into usuario (email, nome_completo, apelido, imagem_perfil, data_nascimento, senha, ativo) values ('maria@cwi.com.br', 'Maria Marques', 'Maria', 'https://upload.wikimedia.org/wikipedia/commons/6/6a/HIRES-AVATAR-AJB.jpg?uselang=pt-br', to_date('1999-03-17', 'YYYY-MM-DD'), '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);
insert into usuario (email, nome_completo, apelido, imagem_perfil, data_nascimento, senha, ativo) values ('pedro@cwi.com.br', 'Pedro Soares', 'Pedro', 'https://upload.wikimedia.org/wikipedia/commons/6/6a/HIRES-AVATAR-AJB.jpg?uselang=pt-br', to_date('1999-05-22', 'YYYY-MM-DD'), '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true);


insert into permissao (nome, usuario_id) values ('USUARIO', 1);
insert into permissao (nome, usuario_id) values ('USUARIO', 2);
insert into permissao (nome, usuario_id) values ('USUARIO', 3);
insert into permissao (nome, usuario_id) values ('USUARIO', 4);


insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://www.showmetech.com.br/wp-content/uploads//2022/07/maxresdefault-298-1024x576.jpg', 'Factory New - Float 0.012', 'CS:GO', '2023-02-23 21:00:00', 1);
insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://www.jaxon.gg/wp-content/uploads/2022/07/awp-banner.jpg', 'Factory New - Float 0.702', 'CS:GO', '2023-02-23 23:00:00', 1);
insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://helios-i.mashable.com/imagery/articles/05KlOqF8BBfOYo1ABZLjRPg/hero-image.fill.size_1248x702.v1623362799.jpg', 'Field Tested - Float 0.1509', 'CS:GO', '2023-02-23 20:00:00', 1);
insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://img.republicworld.com/republic-prod/stories/images/tr:f-png/15960873485f225c34e6fe9.png', 'Factory New - Float 0.112', 'CS:GO', '2023-02-23 22:00:00', 2);
insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://www.talkesport.com/wp-content/uploads/csgo-skins.jpg', 'Factory New - Float 0.002', 'CS:GO', '2023-02-23 23:30:00', 2);
insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://www.jaxon.gg/wp-content/uploads/2022/07/banner.jpg', 'Factory New - Float 0.012', 'CS:GO', '2023-02-23 23:59:00', 3);
insert into postagem (imagem_post, descricao, jogo, data_postagem, usuario_id) values ('https://prod.assets.earlygamecdn.com/images/dragon_lore_awp.jpg?x=0.5&y=0.5', 'Factory New - Float 0.00002', 'CS:GO', '2023-02-23 23:01:00', 4);


insert into lista_amigos(usuario_id, amigo_id) values (1, 2);
insert into lista_amigos(usuario_id, amigo_id) values (1, 4);

insert into solicitacao_amizade (usuario_id, amigo_id) values (1, 3);