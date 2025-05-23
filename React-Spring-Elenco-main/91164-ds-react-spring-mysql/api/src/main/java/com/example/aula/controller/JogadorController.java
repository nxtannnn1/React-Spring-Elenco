package com.example.aula.controller;

import com.example.aula.model.Jogador;
import com.example.aula.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@CrossOrigin(origins = "*")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarJogador(@Valid @RequestBody Jogador jogador) {
        jogadorService.cadastrarJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jogador cadastrado com sucesso");
    }

    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadorService.listarJogadores();
    }

    @GetMapping("/{id}")
    public Jogador listarJogadorPorId(@PathVariable Long id) {
        return jogadorService.listarJogadorPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarJogador(@PathVariable Long id, @Valid @RequestBody Jogador jogador) {
        jogador.setId(id);
        Jogador atualizado = jogadorService.editarJogador(jogador);
        return ResponseEntity.status(HttpStatus.OK).body("Jogador de ID " + atualizado.getId() + " atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirJogador(@PathVariable Long id) {
        jogadorService.excluirJogador(id);
        return ResponseEntity.status(HttpStatus.OK).body("Jogador deletado com sucesso");
    }
}
