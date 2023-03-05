import { useNavigate } from "react-router-dom";
import { useGlobalUser } from "../../context/user/useGlobalUser"; 
import { login } from "../../api/login/login";
import { useState } from "react";
import "./login.screen.style.css"



export function LoginScreen() {

    const [ formInput, setFormInput ] = useState({ username: '', password: ''});
    const [error, setError] = useState("");

    const navigate = useNavigate();
    const [ user, setUser ] = useGlobalUser();

    function handleChange(event) {
        const { name, value } = event.target;
        setFormInput(oldFormInput => ({ ...oldFormInput, [name]: value }));
    }

    async function handleSubmit(event) {
        event.preventDefault();
    
        try {
          const user = await login({
            username: formInput.username,
            password: formInput.password,
        });
        navigate("/home")
        
          setUser(user);
          console.log(user)
        } catch (error) {
          setError("Usuário ou senha incorretos");
        }
      }
      

    return (
      <form onSubmit={handleSubmit} className="formLogin">
            
        <div className="boxInput">        

            <input 
            type="text" 
            name="username" 
            autoComplete="off" 
            value={formInput.username} 
            onChange={handleChange} 
            placeholder="Informe seu email" 
            />

            <input 
            type="password" 
            name="password" 
            autoComplete="off"
            value={formInput.password}
            onChange={handleChange} 
            placeholder="Informe uma senha" 
            />
            {error && <p>{error}</p>}            
            <button type="submit">Login</button>
        </div>
      </form>
    );
}