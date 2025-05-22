package com.example.aula.model;

import com.example.aula.enums.POSICAO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "É necessário inserir uma posição")
    @Column(nullable = false)
    private POSICAO posicao;

    @NotNull(message = "É necessário inserir uma altura válida")
    @Column(nullable = false)
    @DecimalMin(value = "1.40", message = "É necessário ter mais de 1.40 metros!")
    @DecimalMax(value = "2.20", message = "A altura máxima é 2.20 metros")
    private Double altura;

    @NotNull(message = "É necessário inserir um peso válido")
    @Column(nullable = false)
    @DecimalMin(value = "50.00", message = "É necessário ter pelo menos 50kg!")
    @DecimalMax(value = "110.0", message = "O peso máximo é 110kg")
    private Double peso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome não pode ser vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "É necessário inserir uma posição") POSICAO getPosicao() {
        return posicao;
    }

    public void setPosicao(@NotNull(message = "É necessário inserir uma posição") POSICAO posicao) {
        this.posicao = posicao;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura (Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso (Double peso) {
        this.peso = peso;
    }

    public Jogador() {
    }

    public Jogador(Long id, String nome, POSICAO posicao, Double altura, Double peso) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.altura = altura;
        this.peso = peso;
    }
}
