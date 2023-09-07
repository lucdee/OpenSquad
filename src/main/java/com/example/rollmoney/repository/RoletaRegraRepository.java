package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Roleta;
import com.example.rollmoney.entity.RoletaRegra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoletaRegraRepository extends JpaRepository<RoletaRegra, Long> {

    List<RoletaRegra> findByRoletaId(Long idroleta);
}
