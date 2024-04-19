package com.ms.user.service.interfaces;

import com.ms.user.models.request.UsuarioRequest;
import com.ms.user.models.response.UsuarioResponse;


public interface IUsuarioService {

    UsuarioResponse saveUser(UsuarioRequest userRequest);
}
