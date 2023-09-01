package com.example.rollmoney.repository;

import com.example.rollmoney.entity.Carteira;
import com.example.rollmoney.entity.ChatGeral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatGeralRepository extends JpaRepository<ChatGeral, Long> {
}
