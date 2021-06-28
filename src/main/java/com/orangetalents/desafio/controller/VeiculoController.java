package com.orangetalents.desafio.controller;

import com.orangetalents.desafio.dto.request.requestVeiculoDTO;
import com.orangetalents.desafio.dto.response.responseVeiculoDTO;
import com.orangetalents.desafio.entity.Veiculo;
import com.orangetalents.desafio.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    private  VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@Valid @RequestBody requestVeiculoDTO veiculo){
        return new ResponseEntity(veiculoService.cadastrarVeiculo(veiculo), HttpStatus.CREATED);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<responseVeiculoDTO>> listarVeiculosPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(veiculoService.buscarVeiculoPorCPF(cpf));
    }
}
