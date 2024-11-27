package net.weg.ApiEventos.Controller;

import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Participante;
import net.weg.ApiEventos.Service.EventoService;
import net.weg.ApiEventos.Service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/Participante")
public class ParticipanteController {

    @Autowired
    ParticipanteService participanteService;

    @PostMapping("/Post")
    public void salvarParticipante(@RequestBody Participante participante) {
        participanteService.salvarParticipante(participante);
    }

    @PutMapping("/Put")
    public void atualizarParticipante(@RequestBody Participante participante) {
        participanteService.atualizarParticipante(participante);
    }

    @PatchMapping("/Patch")
    public void atualizarParticipante (@RequestParam Integer id, @RequestParam String email) {
        participanteService.atualizarEmailParticipante(id, email);
    }

    @DeleteMapping("/{id}")
    public void deletarParticipante(@PathVariable Integer id) {
        participanteService.deletarParticpante(id);
    }

    @GetMapping("/{id}")
    public Participante buscarParticipante(@PathVariable Integer id) {
        return participanteService.buscarParticipante(id);
    }

    @GetMapping("/GetAll")
    public List<Participante> buscarParticipantes() {
        return participanteService.buscarParticipantes();
    }
}
