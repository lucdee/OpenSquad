package com.example.rollmoney.service;


import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.entity.Perfil;
import com.example.rollmoney.mapper.PerfilMapper;
import com.example.rollmoney.repository.PerfilRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerfilServiceImpl implements PerfilService{

    public final PerfilRepository perfilRepository;

    public final PerfilMapper perfilMapper;


    @Override
    public PerfilDTO save(PerfilDTO perfilDto) {
        Perfil perfil = perfilRepository.findByEmail(perfilDto.getEmail());
        if(perfil !=null){
            throw new ProfileDataException("Já existe uma conta com esse email");
        }
        Perfil perfil1 = perfilRepository.findByUsuario(perfilDto.getUsuario());
        if(perfil1 !=null){
            throw new ProfileDataException("Já existe uma conta com esse usuário");
        }

       Perfil perfilSave =  perfilRepository.save(perfilMapper.map(perfilDto));
        return perfilMapper.map(perfilSave);
    }
}
