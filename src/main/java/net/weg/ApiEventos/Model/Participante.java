package net.weg.ApiEventos.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "participante")
    private List<Inscricao> inscricoes = new ArrayList<>();
}
