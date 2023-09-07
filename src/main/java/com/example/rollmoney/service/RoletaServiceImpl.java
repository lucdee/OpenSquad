package com.example.rollmoney.service;

import com.example.rollmoney.dto.RoletaDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Roleta;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.RoletaMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.RoletaRepository;
import com.example.rollmoney.repository.UsuarioRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.apache.catalina.Role;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoletaServiceImpl implements RoletaService {

    private final RoletaRepository roletaRepository;

    private final RoletaMapper roletaMapper;

    private final AutenticacaoRepository autenticacaoRepository;

    private final UsuarioRepository usuarioRepository;


    @Override
    public RoletaDTO save(RoletaDTO roletaDTO, String token) {

        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);

        if(autenticacao == null){
            throw new ProfileDataException("Erro ao obter perfil");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(autenticacao.getUsuarioid());

        Roleta roleta = roletaMapper.map(roletaDTO);
        roleta.setDatacriada(String.valueOf(LocalDateTime.now()));
        roleta.setUsuariodono(usuario.get());
        roleta.setCorrodada("");
        return roletaMapper.map(roletaRepository.save(roleta));
    }

    @Override
    public List<RoletaDTO> listar(String token) {

        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);

        if(autenticacao == null){
            throw new ProfileDataException("Erro ao obter perfil");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(autenticacao.getUsuarioid());

       List<Roleta> roletas =  roletaRepository.findByUsuariodonoId(usuario.get().getId());
       List<RoletaDTO> roletaDTOS = roletaMapper.map2(roletas);
        return roletaDTOS;
    }

    @Override
    public RoletaDTO editar(RoletaDTO roletaDTO,Long idroleta ,String token) {
        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);

        if(autenticacao == null){
            throw new ProfileDataException("Erro ao obter perfil");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(autenticacao.getUsuarioid());

        Optional<Roleta> roleta = roletaRepository.findById(idroleta);

        if(roleta.get().getUsuariodono().getId() != usuario.get().getId()){
            throw new ProfileDataException("O token não percence á esse usuario");
        }
        if(roleta.isPresent()) {
            roleta.get().setNome(roletaDTO.getNome());
            roleta.get().setEntrada(roletaDTO.getEntrada());
            roletaRepository.save(roleta.get());
        }
       return roletaMapper.map(roleta.get());
    }

    @Override
    public String deletar(Long idroleta, String token) {
        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);

        if(autenticacao == null){
            throw new ProfileDataException("Erro ao obter perfil");
        }
        Optional<Roleta> roleta =  roletaRepository.findById(idroleta);
        if(!roleta.isPresent()){
            throw new ProfileDataException("Roleta não existe");
        }
        if(roleta.get().getUsuariodono().getId() != autenticacao.getUsuarioid()){
            throw new ProfileDataException("O token não percence á esse usuario");
        }

        roletaRepository.deleteById(idroleta);
        return "Roleta Deletada";
    }
}
