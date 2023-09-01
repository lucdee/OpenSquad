package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.CarteiraDTO;
import com.example.rollmoney.dto.UsuarioDTO;
import com.example.rollmoney.entity.Carteira;
import com.example.rollmoney.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarteiraMapper {

    CarteiraDTO map(Carteira carteira);

    Carteira map(CarteiraDTO carteiraDTO);
}
