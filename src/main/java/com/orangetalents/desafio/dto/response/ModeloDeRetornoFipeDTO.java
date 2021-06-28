package com.orangetalents.desafio.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ModeloDeRetornoFipeDTO {

    private List<ObjetoFipeDTO> modelos = new ArrayList<>();
    private List<ObjetoFipeDTO> anos = new ArrayList<>();

    public ModeloDeRetornoFipeDTO() {
    }

    public ModeloDeRetornoFipeDTO(List<ObjetoFipeDTO> modelos, List<ObjetoFipeDTO> anos) {
        this.modelos = modelos;
        this.anos = anos;
    }

    public List<ObjetoFipeDTO> getModelos() {
        return modelos;
    }

    public void setModelos(List<ObjetoFipeDTO> modelos) {
        this.modelos = modelos;
    }

    public List<ObjetoFipeDTO> getAnos() {
        return anos;
    }

    public void setAnos(List<ObjetoFipeDTO> anos) {
        this.anos = anos;
    }
}
