package br.jus.tjba.api.push.usuario.controller;

import br.jus.tjba.api.push.usuario.model.dto.UsuarioDto;
import br.jus.tjba.api.push.usuario.model.form.UsuarioForm;
import br.jus.tjba.api.push.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/teste2")
    public String teste2(){
        return "Será que foi.";
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastro(@Valid @RequestBody UsuarioForm usuarioForm){
        return service.cadastrar(usuarioForm);
    }
}
