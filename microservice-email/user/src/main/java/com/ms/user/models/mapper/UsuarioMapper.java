package com.ms.user.models.mapper;

import com.ms.user.models.entity.Usuario;
import com.ms.user.models.request.UsuarioRequest;
import com.ms.user.models.response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario userRequestToUser(UsuarioRequest userRequest);

    UsuarioResponse userToUserResponse(Usuario user);
}
