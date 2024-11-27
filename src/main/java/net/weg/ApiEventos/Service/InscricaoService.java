package net.weg.ApiEventos.Service;

import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Inscricao;
import net.weg.ApiEventos.Repository.EventoRepository;
import net.weg.ApiEventos.Repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    InscricaoRepository inscricaoRepository;

    public void salvarInscricao(Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }

    public void atualizarInscricao(Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }

    public void deletarInscricao(Integer id) {
        inscricaoRepository.deleteById(id);
    }

    public Inscricao buscarInscricao(Integer id) {
        Optional<Inscricao> inscricaoOptional = inscricaoRepository.findById(id);
        if (inscricaoOptional.isPresent()) {
            return inscricaoOptional.get();
        }
        throw new RuntimeException();
    }

    public List<Inscricao> buscarInscricoes() {
        return inscricaoRepository.findAll();
    }
}
