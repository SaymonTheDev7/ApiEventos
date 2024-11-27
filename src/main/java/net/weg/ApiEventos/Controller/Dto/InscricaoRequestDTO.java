package net.weg.ApiEventos.Controller.Dto;

import lombok.Data;
import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Participante;

@Data
public class InscricaoRequestDTO {
    private Evento evento;
    private Participante participante;
}
