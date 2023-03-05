import { useEffect, useState } from "react";
import { solicitacoesAmizade } from "../../../api/perfil/solicitacoesAmizade";
import './solicitacoes.style.css'

export function Solicitacoes() {
  const [solicitacao, setSolicitacao] = useState([]);

  useEffect(() => {
    async function getSolicitacoes() {
      const solicAmizade = await solicitacoesAmizade();
      setSolicitacao(solicAmizade);
    }
    getSolicitacoes();
  }, []);

    return (
        <div className="solicitacao-box">
            {solicitacao?.map(solicit => (
                <div key={solicit.id}>
                <img src={solicit.imagemPerfil} alt="Imagem Perfil" />
                <p>{solicit.nomeCompleto}</p>
                <p>{solicit.apelido}</p>
                <button>Aceitar</button>
                <button>Recusar</button>
                </div>
            ))}
        </div>
    )
}