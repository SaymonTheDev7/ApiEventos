package net.weg.ApiEventos.Repository;

import net.weg.ApiEventos.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findByNome(String nome);
}
