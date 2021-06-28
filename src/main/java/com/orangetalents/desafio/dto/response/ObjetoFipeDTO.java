package com.orangetalents.desafio.dto.response;

import java.io.Serializable;

public class ObjetoFipeDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nome;
    private String codigo;

    public ObjetoFipeDTO() {
    }

    public ObjetoFipeDTO(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
