import { useState } from "react";
import { criarPostagem } from "../../../api/perfil/criarPostagem";
import "./criarPostagem.style.css"

export function CriarPostagem() {
  const [formInput, setFormInput] = useState({
    imagemPost: "",
    descricao: "",
    jogo: ""
  });

  const [error, setError] = useState("");


  async function handleSubmit(event) {
    event.preventDefault();
    try {
      await criarPostagem({
        imagemPost: formInput.imagemPost,
        descricao: formInput.descricao,
        jogo: formInput.jogo
      });      
    } catch (error) {
        setError("Todos os campos devem ser preenchidos");
    }
  }

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  return (
    <div className="incluir-box">
      <form className="incluir-form" onSubmit={handleSubmit}>
        <h1>Incluir Item</h1>
        
          <label>Imagem Item</label>
          <input
            onChange={handleChange}
            name="imagemPost"
          />    
        
          <label>Descrição</label>
          <input
            onChange={handleChange}
            name="descricao"
          />        
        
          <label>Origem</label>
          <input
            onChange={handleChange}
            name="jogo"
          />
        
        {error && <p>{error}</p>}         
        <button onClick={handleSubmit}>Postar</button>
      </form>
    </div>
  );
}