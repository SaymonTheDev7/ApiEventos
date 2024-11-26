package net.weg.ApiEventos.Repository;

import net.weg.ApiEventos.Model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {
}
