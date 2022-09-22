package com.carraqueta.carraqueta.service;

import com.carraqueta.carraqueta.entity.Veiculo;
import com.carraqueta.carraqueta.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    @Autowired
    VeiculoRepository repository;

    public Veiculo cadatrar(Veiculo veiculo){
        return repository.save(veiculo);
    }

    private void placaValidate(String placa){


    }
}
