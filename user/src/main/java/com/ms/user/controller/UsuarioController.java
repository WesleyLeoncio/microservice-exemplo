package com.ms.user.controller;


import com.ms.user.models.request.UsuarioRequest;
import com.ms.user.models.response.UsuarioResponse;
import com.ms.user.service.interfaces.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UsuarioController {

    final IUsuarioService userService;

    public UsuarioController(IUsuarioService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation( summary = "Adiciona um novo usuario", tags = { "Endpoints De Usuario" } )
    public ResponseEntity<UsuarioResponse> saveUser(@RequestBody @Valid UsuarioRequest userRequest, UriComponentsBuilder uriBuilder) {
       UsuarioResponse userResponse = userService.saveUser(userRequest);
       URI uri =  uriBuilder.path("user/{id}").buildAndExpand(userResponse.userId()).toUri();
       return ResponseEntity.created(uri).body(userResponse);
    }
}
