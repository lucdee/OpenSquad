package com.example.rollmoney.repository;

import com.example.rollmoney.entity.MensagemChatGeral;
import com.example.rollmoney.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensagemChatGeralRepository extends JpaRepository<MensagemChatGeral, Long> {

    List<MensagemChatGeral> findByChatgeralId(Long id);
}
