package net.weg.ApiEventos.Repository;

import net.weg.ApiEventos.Model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

    Optional<Participante> findByEmail(String email);


}
