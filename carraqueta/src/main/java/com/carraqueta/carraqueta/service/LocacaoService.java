package com.carraqueta.carraqueta.service;

import com.carraqueta.carraqueta.entity.Locacao;
import com.carraqueta.carraqueta.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository repository;

    public Locacao locar(Locacao locacao){
        this.locarValidate(locacao);
        return repository.save(locacao);
    }

    public Locacao retornar(Locacao locacao){
        this.retornarValidate(locacao);
        locacao.setDataSaida(LocalDateTime.now());
        return repository.save(locacao);
    }

    private void locarValidate(Locacao locacao){
        boolean isLocado = repository.findByVeiculoAndDataEntradaIsNull(locacao.getVeiculo()).isPresent();
        if(isLocado) {
            throw new RuntimeException("Já locado");
        }
    }

    private void retornarValidate(Locacao locacao){

    }
}
