package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO map(Usuario usuario);

    Usuario map(UsuarioDTO usuarioDTO);
}
