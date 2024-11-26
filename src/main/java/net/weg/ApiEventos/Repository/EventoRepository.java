package net.weg.ApiEventos.Repository;

import net.weg.ApiEventos.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
