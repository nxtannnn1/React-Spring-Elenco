package com.example.aula.service;

import com.example.aula.exception.JogadorNaoEncontradoException;
import com.example.aula.model.Jogador;
import com.example.aula.repository.JogadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador cadastrarJogador(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarJogadores(){
        return jogadorRepository.findAll();
    }

    public Jogador listarJogadorPorId(Long id){
        return jogadorRepository.findById(id).orElseThrow(() -> new JogadorNaoEncontradoException("Jogador de ID "+id+" não encontrado"));
    }

    public Jogador editarJogador (Jogador jogador){
        if(!jogadorRepository.existsById(jogador.getId())){
            throw new JogadorNaoEncontradoException("Jogador de ID "+jogador.getId()+" não encontrado");
        }
        return jogadorRepository.save(jogador);
    }

    public void excluirJogador(Long id){
        if (!jogadorRepository.existsById(id)){
            throw new JogadorNaoEncontradoException("Jogador de ID "+id+" não encontrado");
        }
        jogadorRepository.deleteById(id);
    }

}

