package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Participante;
import com.example.rollmoney.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
