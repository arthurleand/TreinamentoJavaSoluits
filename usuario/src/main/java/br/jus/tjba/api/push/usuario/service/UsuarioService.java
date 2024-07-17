package br.jus.tjba.api.push.usuario.service;

import br.jus.tjba.api.push.usuario.model.EnderecoUsuarioModel;
import br.jus.tjba.api.push.usuario.model.UsuarioModel;
import br.jus.tjba.api.push.usuario.model.dto.EnderecoDTO;
import br.jus.tjba.api.push.usuario.model.dto.UsuarioDto;
import br.jus.tjba.api.push.usuario.model.form.UsuarioForm;
import br.jus.tjba.api.push.usuario.repository.EnderecoUsuarioRepository;
import br.jus.tjba.api.push.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoUsuarioRepository enderecoUsuarioRepository;

    public ResponseEntity<UsuarioModel> cadastrar(UsuarioForm usuarioForm) {
        Optional<UsuarioModel> cpfValidation = usuarioRepository.findByCpf(usuarioForm.cpf());

        if (cpfValidation.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já está sendo utilizado!");
        }

        Optional<UsuarioModel> emailValidation = usuarioRepository.findByLogin(usuarioForm.login());

        if (emailValidation.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já está sendo utilizado!");
        }

        UsuarioModel novoUsuario= new UsuarioModel();
        EnderecoUsuarioModel novoEndereco = new EnderecoUsuarioModel();

        novoEndereco.setUf(usuarioForm.enderecoForm().uf());
        novoEndereco.setCep(usuarioForm.enderecoForm().cep());
        novoEndereco.setRua(usuarioForm.enderecoForm().rua());
        novoEndereco.setCidade(usuarioForm.enderecoForm().cidade());
        novoEndereco.setNumero(usuarioForm.enderecoForm().numero());
        novoEndereco.setBairro(usuarioForm.enderecoForm().bairro());

        novoUsuario.setCpf(usuarioForm.cpf());
        novoUsuario.setSenha(usuarioForm.senha());
        novoUsuario.setLogin(usuarioForm.login());

        usuarioRepository.save(novoUsuario);

        Optional<UsuarioModel> recuperarId = usuarioRepository.findByCpf(usuarioForm.cpf());

        novoEndereco.setId(recuperarId.get().getId());

        return ResponseEntity.status(201).body(enderecoUsuarioRepository.save(novoEndereco).getUsuario());
    }

    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        List<UsuarioModel> usuarioList = usuarioRepository.findAll();

        List<EnderecoUsuarioModel> enderecoList= enderecoUsuarioRepository.findAll();

        List<UsuarioDto> dto = usuarioList.stream().map(usuarioModel -> new UsuarioDto(
                usuarioModel.getId(),
                usuarioModel.getLogin(),
                usuarioModel.getCpf(),
                null
        )).toList();

        for (int i = 0; i < enderecoList.size(); i ++){
            EnderecoDTO enderecoDTO= new EnderecoDTO(
                    enderecoList.get(i).getId(),
                    enderecoList.get(i).getRua(),
                    enderecoList.get(i).getBairro(),
                    enderecoList.get(i).getNumero(),
                    enderecoList.get(i).getCidade(),
                    enderecoList.get(i).getUf(),
                    enderecoList.get(i).getCep()
            );
            dto.get(i).setEndereco(enderecoDTO);
        }
        return ResponseEntity.status(200).body(dto);
    }

    public ResponseEntity<UsuarioDto> listarPorId(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()){
            Optional<EnderecoUsuarioModel> endereco = enderecoUsuarioRepository.findById(id);

            EnderecoDTO enderecoDTO = new EnderecoDTO();

            enderecoDTO.setId(id);
            enderecoDTO.setBairro(endereco.get().getBairro());
            enderecoDTO.setRua(endereco.get().getRua());
            enderecoDTO.setNumero(endereco.get().getNumero());
            enderecoDTO.setCidade(endereco.get().getCidade());
            enderecoDTO.setCep(endereco.get().getCep());
            enderecoDTO.setUf(endereco.get().getUf());

            UsuarioDto usuarioDto = new UsuarioDto();

            usuarioDto.setId(id);
            usuarioDto.setCpf(usuario.get().getCpf());
            usuarioDto.setLogin(usuario.get().getLogin());
            usuarioDto.setEndereco(enderecoDTO);

            return ResponseEntity.status(200).body(usuarioDto);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }

    public ResponseEntity<UsuarioForm> atualizar(Long id, UsuarioForm usuarioForm) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            if(usuarioRepository.findByCpf(usuarioForm.cpf()).isEmpty() ||
                    usuario.get().getCpf().equals(usuarioForm.cpf())){
                if (usuarioRepository.findByLogin(usuarioForm.login()).isEmpty() ||
                        usuario.get().getLogin().equals(usuarioForm.login())){
                    Optional<EnderecoUsuarioModel> endereco = enderecoUsuarioRepository.findById(id);

                    EnderecoUsuarioModel enderecoModel = endereco.get();
                    enderecoModel.setRua(usuarioForm.enderecoForm().rua());
                    enderecoModel.setCep(usuarioForm.enderecoForm().cep());
                    enderecoModel.setNumero(usuarioForm.enderecoForm().numero());
                    enderecoModel.setBairro(usuarioForm.enderecoForm().bairro());
                    enderecoModel.setCidade(usuarioForm.enderecoForm().cidade());
                    enderecoModel.setUf(usuarioForm.enderecoForm().uf());

                    UsuarioModel usuarioModel = usuario.get();
                    usuarioModel.setLogin(usuarioForm.login());
                    usuarioModel.setCpf(usuarioForm.cpf());
                    usuarioModel.setSenha(usuarioForm.senha());

                    usuarioRepository.save(usuarioModel);
                    enderecoUsuarioRepository.save(enderecoModel);

                    return ResponseEntity.ok(usuarioForm);
                }
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já está em uso!!");
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já está em uso!!");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }
}
