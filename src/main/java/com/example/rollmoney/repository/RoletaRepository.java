package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Roleta;
import com.example.rollmoney.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.List;

public interface RoletaRepository extends JpaRepository<Roleta, Long> {

    List<Roleta> findByUsuariodonoId(Long id);
}
