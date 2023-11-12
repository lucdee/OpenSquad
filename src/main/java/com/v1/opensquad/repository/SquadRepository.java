package com.v1.opensquad.repository;

import com.v1.opensquad.entity.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}
