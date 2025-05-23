// components/FormularioCadastro/index.js

import { useState } from "react";
import axios from "axios";
import './styles.css';

function FormularioCadastro({ onCadastroSucesso }) {
  const [nome, setNome] = useState("");
  const [posicao, setPosicao] = useState("");
  const [altura, setAltura] = useState("");
  const [peso, setPeso] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post("http://localhost:8080/jogadores", {
        nome,
        posicao,
        altura: parseFloat(altura),
        peso: parseFloat(peso),
      });

      alert("Jogador cadastrado com sucesso!");

      setNome("");
      setPosicao("");
      setAltura("");
      setPeso("");

      if (onCadastroSucesso) onCadastroSucesso();
    } catch (error) {
      alert("Erro ao cadastrar jogador: " + (error.response?.data?.mensagem || error.message));
    }
  };

  return (
    <form onSubmit={handleSubmit} className="form-cadastro">
      {/* inputs... */}
      <div>
        <label>Nome:</label>
        <input type="text" value={nome} onChange={e => setNome(e.target.value)} required />
      </div>
      <div>
        <label>Posição:</label>
        <select value={posicao} onChange={e => setPosicao(e.target.value)} required>
          <option value="">Selecione...</option>
          <option value="ATAQUE">Ataque</option>
          <option value="MEIA">Meia</option>
          <option value="DEFENSOR">Defensor</option>
          <option value="GOLEIRO">Goleiro</option>
        </select>
      </div>
      <div>
        <label>Altura (m):</label>
        <input type="number" step="0.01" min="1.40" max="2.20" value={altura} onChange={e => setAltura(e.target.value)} required />
      </div>
      <div>
        <label>Peso (kg):</label>
        <input type="number" step="0.1" min="50" max="110" value={peso} onChange={e => setPeso(e.target.value)} required />
      </div>

      <button type="submit">Cadastrar</button>
    </form>
  );
}

export default FormularioCadastro;
