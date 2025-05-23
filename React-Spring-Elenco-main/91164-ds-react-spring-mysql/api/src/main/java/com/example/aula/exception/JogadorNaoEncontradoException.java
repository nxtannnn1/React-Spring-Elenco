package com.example.aula.exception;

public class JogadorNaoEncontradoException extends RuntimeException{

    public JogadorNaoEncontradoException (String mensagem){
        super(mensagem);
    }
}