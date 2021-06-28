package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.response.ModeloDeRetornoFipeDTO;
import com.orangetalents.desafio.dto.response.ObjetoFipeDTO;
import com.orangetalents.desafio.dto.response.responseVeiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ApiFipeService", url = "https://parallelum.com.br/fipe/api/v1")
public interface ApiFipeService{

    @GetMapping("/carros/marcas")
    List<ObjetoFipeDTO> listarMarcas();

    @GetMapping("/carros/marcas/{idMarca}/modelos")
    ModeloDeRetornoFipeDTO listarModelos(@PathVariable("idMarca") String idMarca);

    @GetMapping("/carros/marcas/{idMarca}/modelos/{idModelo}/anos")
    List<ObjetoFipeDTO> listarAnos(@PathVariable("idMarca") String idMarca, @PathVariable("idModelo") String iModelo);

    @GetMapping("/carros/marcas/{idMarca}/modelos/{idModelo}/anos/{ano}")
    responseVeiculoDTO buscarVeiculo(@PathVariable("idMarca") String idMarca,
                                     @PathVariable("idModelo") String idModelo,
                                     @PathVariable("ano") String ano);
}
