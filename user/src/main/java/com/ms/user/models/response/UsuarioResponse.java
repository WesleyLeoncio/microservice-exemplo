package com.ms.user.models.response;

import java.util.UUID;

public record UsuarioResponse(
        UUID userId,
        String nome,
        String email
) {
}
