package net.weg.ApiEventos.Service;
import net.weg.ApiEventos.Controller.Dto.InscricaoRequestDTO;
import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Inscricao;
import net.weg.ApiEventos.Repository.EventoRepository;
import net.weg.ApiEventos.Repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    InscricaoRepository inscricaoRepository;

    @Autowired
    EventoRepository eventoRepository;

    public Inscricao salvarInscricao(InscricaoRequestDTO dto) {
        Inscricao inscricao = dto.conversao();
        return inscricaoRepository.save(inscricao);
    }


    public Inscricao atualizarInscricao(InscricaoRequestDTO dto) {
        Inscricao inscricao = dto.conversao();
        return inscricaoRepository.save(inscricao);
    }

    public Inscricao atualizarEvento(Integer eventoId, Integer id) {
        Inscricao inscricao = buscarInscricao(id);
        try {
            Evento evento = eventoRepository.findById(eventoId).get();
            inscricao.setEvento(evento);
            return inscricaoRepository.save(inscricao);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException();
        }
    }

    public void deletarInscricao(Integer id) {
        if (!inscricaoRepository.existsById(id)){
            throw new NoSuchElementException();
        }
        inscricaoRepository.deleteById(id);
    }

    public Inscricao buscarInscricao(Integer id) {
        Optional<Inscricao> inscricaoOptional = inscricaoRepository.findById(id);
        if (inscricaoOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return inscricaoOptional.get();
    }

    public List<Inscricao> buscarInscricoes() {
        return inscricaoRepository.findAll();
    }
}
