import { useNavigate } from "react-router-dom";
import { logout } from "../../../api/cadastro/logout/logout";
import { useGlobalUser } from "../../../context/user/useGlobalUser";

import "./header.style.css";

export function Header() {

    const [ user ,setUser ] = useGlobalUser();
    const navigate = useNavigate();
    
    async function handleClick(event) {
      event.preventDefault();
      try {
          const user = await logout()
          navigate("/")
      } catch (error) {
          console.log("erro")
      }
  }
    
  return (
    <header className="header-app">
      <div className="header-dados">
        <img src={user?.imagemPerfil} alt="Foto Perfil" />
        <div className="header-infos">
          <p>{user?.apelido}</p>
          <p>{user?.email}</p> 
        </div>
        </div>      
        <button className="button-header" onClick={handleClick}>Logout</button>
    </header>
  );
}
