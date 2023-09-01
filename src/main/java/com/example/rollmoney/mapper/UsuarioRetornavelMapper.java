package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioRetornavelMapper {

    UsuarioDTO map(UsuarioDTO usuarioDTO);
}
