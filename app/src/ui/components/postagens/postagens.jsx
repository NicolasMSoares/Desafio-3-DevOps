import { useEffect, useState } from "react";
import { postagens } from "../../../api/perfil/postagens";
import "./postagens.style.css"

export function Postagens() {
  const [post, setPost] = useState([]);

  useEffect(() => {
    async function getPost() {
      const posts = await postagens();
      setPost(posts);
    }
    getPost();
  }, []);

    return (
        <div>
            <h1>Inventário</h1>
            {post?.map(p => (
                <div key={p.id} className="item-box">
                <img src={p.imagemPost} alt="Imagem Post" />
                <p>{p.descricao}</p>
                <p>{p.jogo}</p>
                </div>
            ))}
        </div>
    )
}
