package br.jus.tjba.api.push.usuario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/teste")
    public String teste(){
        return "Ola mundo.";
    }

    @GetMapping("/teste2")
    public String teste2(){
        return "Será que foi.";
    }
}
