package net.weg.ApiEventos.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inscricao  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Participante participante;
}
