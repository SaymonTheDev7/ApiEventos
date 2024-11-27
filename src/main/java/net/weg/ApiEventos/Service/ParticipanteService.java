package net.weg.ApiEventos.Service;
import net.weg.ApiEventos.Model.Participante;
import net.weg.ApiEventos.Repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    ParticipanteRepository participanteRepository;

    public Participante salvarParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public Participante atualizarParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public Participante atualizarEmailParticipante(Integer id, String email) {
        Participante participante = buscarParticipante(id);
        participante.setEmail(email);
        return participanteRepository.save(participante);
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
