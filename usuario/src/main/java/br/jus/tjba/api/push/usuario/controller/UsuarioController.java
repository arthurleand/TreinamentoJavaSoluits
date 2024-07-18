package br.jus.tjba.api.push.usuario.controller;

import br.jus.tjba.api.push.usuario.model.UsuarioProcessoSistemaModel;
import br.jus.tjba.api.push.usuario.model.dto.UsuarioDto;
import br.jus.tjba.api.push.usuario.model.form.BuscarAssociadosForm;
import br.jus.tjba.api.push.usuario.model.form.UsuarioForm;
import br.jus.tjba.api.push.usuario.model.form.UsuarioProcSistForm;
import br.jus.tjba.api.push.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/buscar-associados-processo")
    public ResponseEntity<List<UsuarioProcessoSistemaModel>> buscarAssocProc(@RequestBody BuscarAssociadosForm associadosForm){
        return service.buscarAssocProc(associadosForm);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastro(@Valid @RequestBody UsuarioForm usuarioForm){
        return service.cadastrar(usuarioForm);
    }

    @PostMapping("/associar-processo")
    @Transactional
    public ResponseEntity<UsuarioProcSistForm> associarProc(@RequestBody UsuarioProcSistForm usuarioProcSistForm){
        return  service.associarProc(usuarioProcSistForm);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioForm> atualizar(@PathVariable Long id, @RequestBody UsuarioForm usuarioForm){
        return service.atualizar(id,usuarioForm);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/desassociar-processo")
    @Transactional
    public void desassociarProc (@RequestBody UsuarioProcSistForm usuarioProcSistForm){
        service.desassociarProc(usuarioProcSistForm);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
