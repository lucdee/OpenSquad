package com.v1.opensquad.service;

import com.v1.opensquad.dto.ConviteDTO;

public interface ConviteService {

    ConviteDTO save(String token, ConviteDTO conviteDTO, String usuario, Long idsquad);
}
