package br.jus.tjba.api.push.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Sistema")
@Table(name = "sistema")
public class SistemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String sigla;

    @OneToMany(mappedBy = "id_sistema", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<UsuarioProcessoSistemaModel> usuarioProcessoSistemaModelList;
}
