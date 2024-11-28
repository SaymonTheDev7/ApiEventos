package net.weg.ApiEventos.Repository;

import net.weg.ApiEventos.Model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {

    void deleteAllByParticipanteId(Integer participanteId);

    List<Inscricao> findAllByParticipanteId(Integer id);

    List<Inscricao> findAllByEventoId(Integer id);
}
