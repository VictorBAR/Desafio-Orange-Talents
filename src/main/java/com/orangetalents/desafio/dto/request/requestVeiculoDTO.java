package com.orangetalents.desafio.dto.request;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class requestVeiculoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String marca;
    @NotEmpty
    private String modelo;
    @NotEmpty
    private String ano;
    @NotEmpty
    private String cpfUsuario;

    public requestVeiculoDTO() {
    }

    public requestVeiculoDTO(String marca, String modelo, String ano, String cpfUsuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cpfUsuario = cpfUsuario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }


}
