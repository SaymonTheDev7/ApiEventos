package net.weg.ApiEventos.Service;

import jakarta.servlet.http.Part;
import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Participante;
import net.weg.ApiEventos.Repository.EventoRepository;
import net.weg.ApiEventos.Repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    ParticipanteRepository participanteRepository;

    public void salvarParticipante(Participante participante) {
        participanteRepository.save(participante);
    }

    public void atualizarParticipante(Participante participante) {
        participanteRepository.save(participante);
    }

    public void atualizarEmailParticipante(Integer id, String email) {
        Optional<Participante> participanteOptional = participanteRepository.findById(id);
        Participante participante = participanteOptional.get();
        participante.setEmail(email);
        participanteRepository.save(participante);
    }

    public void deletarParticpante(Integer id) {
        participanteRepository.deleteById(id);
    }

    public Participante buscarParticipante(Integer id) {
        Optional<Participante> participanteOptional = participanteRepository.findById(id);
        if (participanteOptional.isPresent()) {
            return participanteOptional.get();
        }
        throw new RuntimeException();
    }

    public List<Participante> buscarParticipantes() {
        return participanteRepository.findAll();
    }
}
