package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.PerfilDTO;
import com.example.rollmoney.dto.RetornoPerfilDTO;
import com.example.rollmoney.entity.Perfil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilMapper {

    Perfil map(PerfilDTO perfilDto);

    PerfilDTO map(Perfil perfil);

    RetornoPerfilDTO mapRetorno(Perfil perfil);
}
