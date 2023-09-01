package com.example.rollmoney.service;

import com.example.rollmoney.dto.ChatGeralDTO;
import com.example.rollmoney.dto.chat.MensagemChatGeralDTO;
import com.example.rollmoney.dto.chat.MensagemChatGeralRetornoDTO;
import com.example.rollmoney.entity.ChatGeral;
import com.example.rollmoney.entity.MensagemChatGeral;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.ChatGeralMapper;
import com.example.rollmoney.mapper.MensagemChatGeralMapper;
import com.example.rollmoney.mapper.UsuarioMapper;
import com.example.rollmoney.repository.ChatGeralRepository;
import com.example.rollmoney.repository.MensagemChatGeralRepository;
import com.example.rollmoney.repository.UsuarioRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ChatGeralServiceImpl implements ChatGeralService {

   private final ChatGeralRepository chatGeralRepository;

   private final ChatGeralMapper chatGeralMapper;

   private final UsuarioRepository usuarioRepository;

   private final UsuarioMapper usuarioMapper;

   private final MensagemChatGeralRepository mensagemChatGeralRepository;

   private final MensagemChatGeralMapper mensagemChatGeralMapper;


    @Override
    public ChatGeralDTO save(ChatGeralDTO chatGeralDTO) {
        chatGeralRepository.save(chatGeralMapper.map(chatGeralDTO));
        return chatGeralDTO;
    }

    @Override
    public String enviarmensagem(MensagemChatGeralDTO mensagemChatGeralDTO) {
       Optional<Usuario> usuario = usuarioRepository.findById(mensagemChatGeralDTO.getUsuarioid());
       if (usuario == null){
           throw new ProfileDataException("Usuario não encontrado");
       }

       ChatGeral chatGeral = chatGeralRepository.getById(mensagemChatGeralDTO.getChatgeral());
        if (chatGeral == null){
            throw new ProfileDataException("Chat geral não encontrado");
        }

        MensagemChatGeral mensagemChatGeral = new MensagemChatGeral();
        mensagemChatGeral.setUsuario(usuario.get());
        mensagemChatGeral.setMensagem(mensagemChatGeralDTO.getMensagem());
        mensagemChatGeral.setDataenvio(LocalDate.now().toString());
        mensagemChatGeral.setChatgeral(chatGeral);

        mensagemChatGeralRepository.save(mensagemChatGeral);
        return "enviado";
    }

    @Override
    public List<MensagemChatGeralRetornoDTO> listarmensagens(Long mensagemchatid) {
    List<MensagemChatGeral> mensagemChatGeral = mensagemChatGeralRepository.findByChatgeralId(mensagemchatid);

    if(mensagemChatGeral.isEmpty()){
        throw new ProfileDataException("Nenhuma mensagem encontrada nesse perfil");
    }

    List<MensagemChatGeralRetornoDTO> mensagemChatGeralDTOS = mensagemChatGeralMapper.map2(mensagemChatGeral);
    return mensagemChatGeralDTOS;
    }
}
