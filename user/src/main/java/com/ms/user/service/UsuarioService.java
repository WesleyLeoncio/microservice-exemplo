package com.ms.user.service;

import com.ms.user.models.entity.Usuario;
import com.ms.user.models.mapper.UsuarioMapper;
import com.ms.user.models.request.UsuarioRequest;
import com.ms.user.models.response.UsuarioResponse;
import com.ms.user.producers.UsuarioProducer;
import com.ms.user.repository.UsuarioRepository;
import com.ms.user.service.interfaces.IUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements IUsuarioService {

    final UsuarioRepository userRepository;

    final UsuarioProducer usuarioProducer;

    public UsuarioService(UsuarioRepository userRepository, UsuarioProducer usuarioProducer) {
        this.userRepository = userRepository;
        this.usuarioProducer = usuarioProducer;
    }

    @Override
    @Transactional
    public UsuarioResponse saveUser(UsuarioRequest userRequest) {
        Usuario user = userRepository.save(UsuarioMapper.INSTANCE.userRequestToUser(userRequest));
        if (Boolean.TRUE.equals(verificarEmail(user.getEmail()))) {
            usuarioProducer.publishMessageEmail(user);
        }
        return UsuarioMapper.INSTANCE.userToUserResponse(user);
    }

    private Boolean verificarEmail (String email) {
        Usuario user = userRepository.findByEmail(email);
        return  user != null;
    }


}
