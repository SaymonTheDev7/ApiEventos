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

    public void salvarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public void atualizarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public void atualizarDataEvento(Integer id, String data) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        Evento evento = eventoOptional.get();
        evento.setData(data);
        eventoRepository.save(evento);
    }

    public void deletarEvento(Integer id) {
        eventoRepository.deleteById(id);
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
