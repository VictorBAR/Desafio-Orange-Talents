package com.orangetalents.desafio.dto.response;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class responseVeiculoDTO {

    private String marca;
    private String modelo;
    private String ano;
    private String cpfUsuario;
    private String valor;
    private String diaRodizio;
    private boolean rodizioAtivo;

}
