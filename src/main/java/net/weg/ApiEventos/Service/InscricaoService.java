package net.weg.ApiEventos.Service;

import net.weg.ApiEventos.Model.Inscricao;
import net.weg.ApiEventos.Repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {

    @Autowired
    InscricaoRepository inscricaoRepository;
}
