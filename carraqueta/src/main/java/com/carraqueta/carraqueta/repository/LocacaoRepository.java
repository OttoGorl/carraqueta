package com.carraqueta.carraqueta.repository;

import com.carraqueta.carraqueta.entity.Locacao;
import com.carraqueta.carraqueta.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    Optional<Locacao> findByVeiculoAndDataSaidaIsNull(Veiculo veiculo);
    List<Locacao> findByDataSaidaIsNull();

    @Query("SELECT locacao FROM Locacao locacao JOIN locacao.veiculo veiculo where veiculo.placa = :placa")
    Locacao findLocacaoByPlaca(String placa);

    @Query("SELECT locacao FROM Locacao locacao WHERE locacao.dataSaida = null GROUP BY COUNT(locacao.veiculo) order by COUNT(locacao.veiculo)")
    List<Locacao> findMaisLocados();
}
