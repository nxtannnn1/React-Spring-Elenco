package com.example.aula.enums;

public enum POSICAO {
    ATAQUE("Ataque"),
    MEIA("Meia"),
    DEFENSOR("Defensor"),
    GOLEIRO("Goleiro");

    private final String descricao;

    POSICAO (String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }


}
