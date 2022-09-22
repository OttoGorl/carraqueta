package com.carraqueta.carraqueta.repository;

import com.carraqueta.carraqueta.entity.Locacao;
import com.carraqueta.carraqueta.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    Optional<Locacao> findByVeiculoAndDataEntradaIsNull(Veiculo veiculo);
}
