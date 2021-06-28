package com.orangetalents.desafio.dto.request;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

public class requestUsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Column(unique = true)
    private String cpf;

    @NotEmpty
    @Column(unique = true)
    private String email;

    @NonNull
    private LocalDate dataNascimento;

    public requestUsuarioDTO() {
    }

    public requestUsuarioDTO(String nome, String cpf, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
