package net.weg.ApiEventos.Controller;
import net.weg.ApiEventos.Model.Participante;
import net.weg.ApiEventos.Service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("API/Participante")
public class ParticipanteController {

    @Autowired
    ParticipanteService participanteService;

    @PostMapping("/Post")
    public ResponseEntity<Participante> salvarParticipante(@RequestBody Participante participante) {
        participante = participanteService.salvarParticipante(participante);
        return new  ResponseEntity<>(participante, HttpStatus.CREATED);
    }

    @PutMapping("/Put")
    public ResponseEntity<Participante> atualizarParticipante(@RequestBody Participante participante) {
        participante = participanteService.atualizarParticipante(participante);
        return new ResponseEntity<>(participante, HttpStatus.OK);
    }

    @PatchMapping("/Patch")
    public ResponseEntity<Participante> atualizarParticipante (@RequestParam Integer id, @RequestParam String email) {
        try {
            Participante participante = participanteService.atualizarEmailParticipante(id, email);
            return new ResponseEntity<>(participante, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarParticipante(@PathVariable Integer id) {
        participanteService.deletarParticpante(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participante> buscarParticipante(@PathVariable Integer id) {
         try {
             Participante participante = participanteService.buscarParticipante(id);
             return new ResponseEntity<>(participante, HttpStatus.OK);
         } catch (NoSuchElementException e) {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<Participante>> buscarParticipantes() {
        List<Participante> participantes = participanteService.buscarParticipantes();
        if (!participantes.isEmpty()) {
            return new ResponseEntity<>(participantes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/GetByEmail/{email}")
    public ResponseEntity<Participante> buscarParticipantePorEmail(@RequestParam String email) {
        try {
            Participante participante = participanteService.buscarParticipantePorEmail(email);
            return new ResponseEntity<>(participante, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
