package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.request.requestUsuarioDTO;
import com.orangetalents.desafio.exception.FormatoDeCpfInvalido;
import com.orangetalents.desafio.exception.ResourceNotFoundException;
import com.orangetalents.desafio.entity.Usuario;
import com.orangetalents.desafio.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public Usuario cadastrarUsuario(requestUsuarioDTO usuario){
       long cpf = Long.parseLong(usuario.getCpf());
       try{
           if(usuarioRepository.findById(cpf).isPresent()) {
               throw new ResourceNotFoundException("Usuario já cadastrado!");
           }
       }catch (NumberFormatException e){
           throw new FormatoDeCpfInvalido("Digite apenas numeros!");
       }
       return usuarioRepository.save(modelMapper.map(usuario, Usuario.class));
    }

}
