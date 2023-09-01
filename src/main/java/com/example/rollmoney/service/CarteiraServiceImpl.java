package com.example.rollmoney.service;

import com.example.rollmoney.dto.CarteiraDTO;
import com.example.rollmoney.entity.Carteira;
import com.example.rollmoney.entity.Usuario;
import com.example.rollmoney.mapper.CarteiraMapper;
import com.example.rollmoney.mapper.UsuarioMapper;
import com.example.rollmoney.repository.CarteiraRepository;
import com.example.rollmoney.repository.UsuarioRepository;
import com.example.rollmoney.service.exception.ProfileDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarteiraServiceImpl implements CarteiraService{

    private final CarteiraRepository carteiraRepository;

    private final CarteiraMapper carteiraMapper;

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;
    @Override
    public CarteiraDTO save(Long id) {
       Carteira carteira2 = carteiraRepository.findByUsuarioId(id);
       if(carteira2 != null){
           throw new ProfileDataException("O usuário já possui uma carteira, para criar outra contacte um admin");
       }

       Optional<Usuario> usuario = usuarioRepository.findById(id);
       Carteira carteira = new Carteira();
        carteira.setSaldo(BigInteger.valueOf(0));
        carteira.setUsuario(usuario.get());
        Carteira carteiraSalva = carteiraRepository.save(carteira);
       return carteiraMapper.map(carteiraSalva);
    }
}
