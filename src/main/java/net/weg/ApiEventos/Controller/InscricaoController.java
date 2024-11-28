package net.weg.ApiEventos.Controller;
import net.weg.ApiEventos.Controller.Dto.InscricaoRequestDTO;
import net.weg.ApiEventos.Model.Inscricao;
import net.weg.ApiEventos.Service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("API/Inscricao")
public class InscricaoController {

    @Autowired
    InscricaoService inscricaoService;

    @PostMapping("/Post")
    public ResponseEntity<Inscricao> salvarInscricao(@RequestBody InscricaoRequestDTO dto) {
        try {
            Inscricao inscricao = inscricaoService.salvarInscricao(dto);
            return new ResponseEntity<>(inscricao, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/Put")
    public ResponseEntity<Inscricao> atualizarInscricao(@RequestBody InscricaoRequestDTO dto) {
       try {
           Inscricao inscricao = inscricaoService.atualizarInscricao(dto);
           return new ResponseEntity<>(inscricao, HttpStatus.OK);
       } catch (NoSuchElementException e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @PatchMapping("/Patch")
    public ResponseEntity<Inscricao> atualizarEvento (@RequestParam Integer eventoId, @RequestParam Integer id) {
        try {
            Inscricao inscricao = inscricaoService.atualizarEvento(id, eventoId);
            return new ResponseEntity<>(inscricao, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarInscricao(@PathVariable Integer id) {
        try {
            inscricaoService.deletarInscricao(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarInscriao(@PathVariable Integer id) {
        Inscricao inscricao = inscricaoService.buscarInscricao(id);
        if (inscricao != null) {
            return new ResponseEntity<>(inscricao, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/GetAll")
    public ResponseEntity<List<Inscricao>> buscarInscricoes() {
        List<Inscricao> inscricoes = inscricaoService.buscarInscricoes();

        if (inscricoes!=null) {
            return new ResponseEntity<>(inscricoes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
