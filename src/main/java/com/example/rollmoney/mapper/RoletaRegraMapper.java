package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.RoletaRegraDTO;
import com.example.rollmoney.entity.RoletaRegra;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoletaRegraMapper {

    RoletaRegra map(RoletaRegraDTO roletaRegraDTO);

    RoletaRegraDTO map(RoletaRegra roletaRegra);

    List<RoletaRegra> map3(List<RoletaRegraDTO> roletaRegraDTO);

    List<RoletaRegraDTO> map2(List<RoletaRegra> roletaRegra);
}
