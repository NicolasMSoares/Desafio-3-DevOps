import { instance } from "../../configs/httpClient"; 


export async function criarPostagem({imagemPost, descricao, jogo}) {
  const response = await instance.post('/perfil/postagem', {
    imagemPost,
    descricao,
    jogo
  });
  return response.data;
}