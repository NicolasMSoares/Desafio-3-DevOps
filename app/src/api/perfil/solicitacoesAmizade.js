import { instance } from "../../configs/httpClient"; 

export async function solicitacoesAmizade() {
  const response = await instance.get('/perfil/solicitacoes');
  return response.data;
}
