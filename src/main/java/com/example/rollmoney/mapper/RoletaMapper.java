package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.RoletaDTO;
import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.entity.Roleta;
import com.example.rollmoney.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoletaMapper {

    RoletaDTO map(Roleta roleta);

    Roleta map(RoletaDTO roleta);

    List<RoletaDTO> map2(List<Roleta> roleta);
}
