package com.example.rollmoney.service;

import com.example.rollmoney.dto.RoletaRegraDTO;
import com.example.rollmoney.entity.Autenticacao;
import com.example.rollmoney.entity.Roleta;
import com.example.rollmoney.entity.RoletaRegra;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.RoletaMapper;
import com.example.rollmoney.mapper.RoletaRegraMapper;
import com.example.rollmoney.repository.AutenticacaoRepository;
import com.example.rollmoney.repository.RoletaRegraRepository;
import com.example.rollmoney.repository.RoletaRepository;
import com.example.rollmoney.repository.UsuarioRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoletaRegraServiceImpl implements RoletaRegraService {

    private final AutenticacaoRepository autenticacaoRepository;

    private final UsuarioRepository usuarioRepository;

    private final RoletaRepository roletaRepository;

    private final RoletaRegraRepository roletaRegraRepository;

    private final RoletaRegraMapper roletaRegraMapper;

    private final RoletaMapper roletaMapper;

    @Override
    public RoletaRegraDTO save(RoletaRegraDTO roletaRegraDTO,Long idroleta  ,String token) {
        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);

        if (autenticacao == null) {
            throw new ProfileDataException("Erro ao obter perfil");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(autenticacao.getUsuarioid());

        if (usuario.get().getId() != autenticacao.getUsuarioid()) {
            throw new ProfileDataException("O token não percence á esse usuario");
        }

        Optional<Roleta> roleta = roletaRepository.findById(idroleta);
        if (usuario.get().getId() != roleta.get().getUsuariodono().getId()) {
            throw new ProfileDataException("O token não percence á essa roleta");
        }

        roletaRegraDTO.setRoleta(roletaMapper.map(roleta.get()));
        roletaRegraRepository.save(roletaRegraMapper.map(roletaRegraDTO));
        return roletaRegraDTO;

    }

    @Override
    public List<RoletaRegraDTO> findByRoleta(Long idroleta, String token) {

        Autenticacao autenticacao = autenticacaoRepository.findByToken(token);

        if (autenticacao == null) {
            throw new ProfileDataException("Erro ao obter perfil");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(autenticacao.getUsuarioid());

        if (usuario.get().getId() != autenticacao.getUsuarioid()) {
            throw new ProfileDataException("O token não percence á esse usuario");
        }

        Optional<Roleta> roleta = roletaRepository.findById(idroleta);
        if (!roleta.isPresent()) {
            throw new ProfileDataException("Roleta não existe");
        }
        if (usuario.get().getId() != roleta.get().getUsuariodono().getId()) {
            throw new ProfileDataException("O token não percence á essa roleta");
        }

       List<RoletaRegra> roletaRegras = roletaRegraRepository.findByRoletaId(idroleta);
        return roletaRegraMapper.map2(roletaRegras);
    }
}
