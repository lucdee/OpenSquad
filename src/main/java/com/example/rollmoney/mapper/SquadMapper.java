package com.example.rollmoney.mapper;

import com.example.rollmoney.dto.SquadDTO;
import com.example.rollmoney.entity.Squad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SquadMapper {

    SquadDTO map(Squad squad);

    Squad map(SquadDTO squad);
}
