package com.v1.opensquad.service;


import com.v1.opensquad.dto.PerfilDTO;
import com.v1.opensquad.entity.Perfil;
import com.v1.opensquad.mapper.PerfilMapper;
import com.v1.opensquad.repository.PerfilRepository;
import com.v1.opensquad.service.exception.ProfileDataException;
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
