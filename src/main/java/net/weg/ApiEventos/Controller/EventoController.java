package net.weg.ApiEventos.Controller;

import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/Eventos")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @PostMapping("/Post")
    public void salvarEvento(@RequestBody Evento evento) {
        eventoService.salvarEvento(evento);
    }

    @PutMapping("/Put")
    public void atualizarEvento(@RequestBody Evento evento) {
        eventoService.atualizarEvento(evento);
    }

    @PatchMapping("/Patch")
    public void atualizarDataEvento (@RequestParam Integer id, @RequestParam String data) {
        eventoService.atualizarDataEvento(id, data);
    }

    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Integer id) {
        eventoService.deletarEvento(id);
    }

    @GetMapping("/{id}")
    public Evento buscarEvento(@PathVariable Integer id) {
        return eventoService.buscarEvento(id);
    }

    @GetMapping("/GetAll")
    public List <Evento> buscarEventos() {
        return eventoService.buscarEventos();
    }
}
