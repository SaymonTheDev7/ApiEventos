package net.weg.ApiEventos.Controller.Dto;

import lombok.Data;
import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Inscricao;
import net.weg.ApiEventos.Model.Participante;

@Data
public class InscricaoRequestDTO {
    private Evento evento;
    private Participante participante;

    public Inscricao conversao() {
        Inscricao inscricao = new Inscricao();
        inscricao.setEvento(this.getEvento());
        inscricao.setParticipante(this.getParticipante());
        return inscricao;
    }
}
