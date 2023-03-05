import { instance } from "../../configs/httpClient"; 

export async function postagens() {
  const response = await instance.get('/perfil/listar-postagens');
  return response.data;
}