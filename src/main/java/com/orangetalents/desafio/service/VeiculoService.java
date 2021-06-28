package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.request.requestVeiculoDTO;
import com.orangetalents.desafio.dto.response.ObjetoFipeDTO;
import com.orangetalents.desafio.dto.response.responseVeiculoDTO;
import com.orangetalents.desafio.exception.ResourceNotFoundException;
import com.orangetalents.desafio.entity.Usuario;
import com.orangetalents.desafio.entity.Veiculo;
import com.orangetalents.desafio.repository.UsuarioRepository;
import com.orangetalents.desafio.repository.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    private final ApiFipeService apiFipeService;
    private final UsuarioRepository usuarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final RodizioService rodizioService;
    private final ModelMapper modelMapper;

    public VeiculoService(ApiFipeService apiFipeService, UsuarioRepository usuarioRepository, VeiculoRepository veiculoRepository, RodizioService rodizioService, ModelMapper modelMapper) {
        this.apiFipeService = apiFipeService;
        this.usuarioRepository = usuarioRepository;
        this.veiculoRepository = veiculoRepository;
        this.rodizioService = rodizioService;
        this.modelMapper = modelMapper;
    }

    public Veiculo cadastrarVeiculo(requestVeiculoDTO veiculoDTO){
        Usuario usuario = usuarioRepository.findByCpf(veiculoDTO.getCpfUsuario());
        Veiculo veiculo = modelMapper.map(veiculoDTO, Veiculo.class);
        veiculo.setUsuario(usuario);
        return veiculoRepository.save(veiculo);
    }

    public String buscarValorDoVeiculo(Veiculo veiculo){
        List<ObjetoFipeDTO> marcas = apiFipeService.listarMarcas();
        boolean marcaValida = false, modeloValido = false, anoValido = false;
        String codigoMarca = "";

        for (ObjetoFipeDTO marca : marcas) {
            if (marca.getNome().equals(veiculo.getMarca())) {
                marcaValida = true;
                codigoMarca = marca.getCodigo();
            }
        }
        ObjetoFipeDTO modelo = apiFipeService.listarModelos(codigoMarca).getModelos()
                .stream().filter(m -> m.getNome().equals(veiculo.getModelo()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Modelo não encontrado!"));

        ObjetoFipeDTO ano = apiFipeService.listarAnos(codigoMarca, modelo.getCodigo())
                .stream().filter(x -> x.getNome().contains(veiculo.getAno()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Ano não encontrado"));

        String valor = apiFipeService.buscarVeiculo(codigoMarca, modelo.getCodigo(), ano.getCodigo()).getValor();
        if(valor == null) valor = "valor não encontrado";

        return valor;
    }

    public List<responseVeiculoDTO> buscarVeiculoPorCPF(String cpf){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        List<responseVeiculoDTO> veiculosUsuario = new ArrayList<>();

        for(Veiculo veiculo: veiculos){
            if(veiculo.getUsuario().getCpf().equals(cpf)){

                responseVeiculoDTO veiculoDTO = modelMapper.map(veiculo, responseVeiculoDTO.class);

                veiculoDTO.setRodizioAtivo(rodizioService.diaPermitido(veiculoDTO.getAno()));

                veiculoDTO.setDiaRodizio(rodizioService.diaSemana(veiculoDTO.getAno()));

                veiculoDTO.setValor(buscarValorDoVeiculo(veiculo));

                veiculosUsuario.add(veiculoDTO);
            }
        }
        return veiculosUsuario;
    }

}
