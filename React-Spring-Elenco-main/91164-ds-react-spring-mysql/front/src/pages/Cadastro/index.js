import { useState, useEffect } from "react";
import axios from "axios";

import FormularioCadastro from "../../components/FormularioCadastro";
import ListaDeJogadores from "../../components/ListaDeJogadores";

import realLogo from '../../assets/images/logo.png';

import './styles.css';

function PaginaCadastro() {
  const [jogadores, setJogadores] = useState([]);
  const [mostrarLista, setMostrarLista] = useState(false);

  const carregarJogadores = async () => {
    try {
      const response = await axios.get("http://localhost:8080/jogadores");
      setJogadores(response.data);
    } catch (error) {
      alert("Erro ao carregar jogadores: " + (error.response?.data?.mensagem || error.message));
    }
  };

  useEffect(() => {
    if (mostrarLista) {
      carregarJogadores();
    }
  }, [mostrarLista]);

  // Essa função é passada para o formulário para recarregar a lista após cadastro
  const aoCadastrar = () => {
    if (mostrarLista) {
      carregarJogadores();
    }
  };

  return (
    <div className="pagina-cadastro">
      <img src={realLogo} alt="Logo Real Madrid" className="logo-real" />

      <h1>Cadastro de Jogadores</h1>
      <FormularioCadastro onCadastroSucesso={aoCadastrar} />

      <button
        className="btn-toggle-lista"
        onClick={() => setMostrarLista(!mostrarLista)}
      >
        {mostrarLista ? "Esconder Lista de Jogadores" : "Mostrar Lista de Jogadores"}
      </button>

      {mostrarLista && (
        <>
          <h2>Jogadores Cadastrados</h2>
          <ListaDeJogadores jogadores={jogadores} />
        </>
      )}
    </div>
  );
}

export default PaginaCadastro;
