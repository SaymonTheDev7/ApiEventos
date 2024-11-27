package net.weg.ApiEventos.Controller;

import net.weg.ApiEventos.Controller.Dto.InscricaoRequestDTO;
import net.weg.ApiEventos.Model.Evento;
import net.weg.ApiEventos.Model.Inscricao;
import net.weg.ApiEventos.Service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/Inscricao")
public class InscricaoController {

    @Autowired
    InscricaoService inscricaoService;

    @PostMapping("/Post")
    public ResponseEntity<Inscricao> salvarInscricao(@RequestBody InscricaoRequestDTO dto) {
       Inscricao inscricao = inscricaoService.salvarInscricao(dto);
    }

    @PutMapping("/Put")
    public void atualizarInscricao(@RequestBody Inscricao inscricao) {
        inscricaoService.atualizarInscricao(inscricao);
    }

    @DeleteMapping("/{id}")
    public void deletarInscricao(@PathVariable Integer id) {
        inscricaoService.deletarInscricao(id);
    }

    @GetMapping("/{id}")
    public Inscricao buscarInscriao(@PathVariable Integer id) {
        return inscricaoService.buscarInscricao(id);
    }
    @GetMapping("/GetAll")
    public List<Inscricao> buscarInscricoes() {
        return inscricaoService.buscarInscricoes();
    }
}
