import "./home.screen.style.css";
import { CriarPostagem } from "../../ui/components/fazer-postagem/criarPostagem";
import { Header } from "../../ui/components/header/header";
import { Postagens } from "../../ui/components/postagens/postagens";
import { Solicitacoes } from "../../ui/components/solicitacoes/solicitacoes";

export function HomeScreen() {
  return (
    <>
      <Header />
      <div className="home-box">
        <Solicitacoes />
        <Postagens />
        <CriarPostagem />
      </div>
    </>
  );
}
