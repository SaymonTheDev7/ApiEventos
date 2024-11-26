package net.weg.ApiEventos.Service;

import net.weg.ApiEventos.Repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

    @Autowired
    ParticipanteRepository participanteRepository;
}
