package net.weg.ApiEventos.Repository;

import net.weg.ApiEventos.Model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
}
