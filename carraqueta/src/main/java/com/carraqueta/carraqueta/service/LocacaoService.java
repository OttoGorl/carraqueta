package com.carraqueta.carraqueta.service;

import com.carraqueta.carraqueta.entity.Locacao;
import com.carraqueta.carraqueta.entity.Veiculo;
import com.carraqueta.carraqueta.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        boolean isLocado = repository.findByVeiculoAndDataSaidaIsNull(locacao.getVeiculo()).isPresent();
        if(isLocado) {
            throw new RuntimeException("Já locado");
        }
    }

    private void retornarValidate(Locacao locacao){

    }
    public List<Veiculo> buscarVeiculosEmLocacaoAtiva(){
        return repository.findByDataSaidaIsNull().stream().map(Locacao::getVeiculo).collect(Collectors.toList());

    }

    public Locacao findLocacaoByPlaca(String placa) {
        return repository.findLocacaoByPlaca(placa);
    }

    public List<Veiculo> findMaisLocados() {

        return repository.findMaisLocados().stream().map(Locacao::getVeiculo).collect(Collectors.toList());
    }
}
