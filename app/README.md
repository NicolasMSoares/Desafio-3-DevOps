
# MINHA REDE SOCIAL
O objetivo da rede social seria de poder compartilhar com os amigos as conquistas realizadas em diversos jogos e poder centralizar diversos inventarios em um lugar só.



## Instalação App

```bash
  npm install 
  cd app
```


## Dependencias Api

```bash
  - Java 11
  - PostgreSQL 14
  - Criar objetos no banco: `data/schema.sql`
  - Carga inicial: `data/insert.sql`
  - Arquivo do postman: `data/TCC.postman_collection.json`
```

## Funcionalidades

```bash
  - Incluir usuário: `POST /usuarios`  
  - Realizar login: `POST /login`
  - Realizar logout: `POST /logout`
  - Exibir usuário logado: `GET /usuarios/me`
  - Listar solicitações de amizade: `GET /perfil/solicitacoes`
  - Realizar pedido de amizade: `PUT /perfil/{id}/solicitar-amizade`
  - Adicionar amigo: `PUT /perfil/{id}/adicionar-amigo`
  - Rejeitar solicitação de amizade: `PUT /perfil/{id}/rejeitar-solicitacao`
  - Buscar usuários paginado: `GET /perfil/buscar-contato?text=cwi&size=4&page=0`
  - Listar amigos paginado: `GET /perfil/lista-amigos?text=cwi&size=4&page=0`
  - Listar postagens: `GET /perfil/listar-postagens`
  - Desfazer amizade: `PUT /perfil/{id}/desfazer-amizade`
  - Criar postagens: `GET /perfil/postagem`
  - Editar perfil: `PUT /perfil/editar-perfil`
```
    