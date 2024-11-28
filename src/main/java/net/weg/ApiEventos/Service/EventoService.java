package net.weg.ApiEventos.Service;

import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.RuntimeMBeanException;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public Evento salvarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento atualizarEvento(Evento evento) {
        if (eventoRepository.findById(evento.getId()).isPresent()) {
            evento.setId(evento.getId());
            return eventoRepository.save(evento);
        }
        throw new RuntimeException();
    }

    public Evento atualizarDataEvento(Integer id, String data) {
        Evento evento = eventoRepository.findById(id).get();
        evento.setData(data);
        return eventoRepository.save(evento);
    }

    public void deletarEvento(Integer id) {
        if (eventoRepository.findById(id).isPresent()) {
            eventoRepository.deleteById(id);
        }
        throw new RuntimeException();
    }

    public Evento buscarEvento(Integer id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        if (eventoOptional.isPresent()) {
            return eventoOptional.get();
        }
        throw new RuntimeException();
    }

    public List<Evento> buscarEventos() {
        return eventoRepository.findAll();
    }
}
