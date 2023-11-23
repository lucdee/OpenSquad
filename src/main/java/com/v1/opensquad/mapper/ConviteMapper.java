package com.v1.opensquad.mapper;

import com.v1.opensquad.dto.ConviteDTO;
import com.v1.opensquad.entity.Convite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConviteMapper {

    ConviteDTO map(Convite convite);

    Convite map(ConviteDTO conviteDTO);
}
