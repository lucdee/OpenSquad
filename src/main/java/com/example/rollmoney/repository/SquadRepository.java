package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Perfil;
import com.example.rollmoney.entity.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}
