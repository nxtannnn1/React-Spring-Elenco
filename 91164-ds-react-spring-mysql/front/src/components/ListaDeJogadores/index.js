// components/ListaDeJogadores/index.js

import './styles.css';

function ListaDeJogadores({ jogadores }) {
  if (!jogadores || jogadores.length === 0) {
    return <p>Nenhum jogador cadastrado.</p>;
  }

  return (
    <ul className="lista-jogadores">
      {jogadores.map(jogador => (
        <li key={jogador.id} className="item-jogador">
          <strong>Nome:</strong> {jogador.nome}<br />
          <strong>Posição:</strong> {jogador.posicao}<br />
          <strong>Altura:</strong> {jogador.altura} m<br />
          <strong>Peso:</strong> {jogador.peso} kg
        </li>
      ))}
    </ul>
  );
}

export default ListaDeJogadores;
