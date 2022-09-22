package com.carraqueta.carraqueta.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOCACAO")
@Getter
@Setter
@NoArgsConstructor
public class Locacao {

    public Locacao(String nomeCliente, String cpf, LocalDateTime dataEntrada, BigDecimal valor, Veiculo veiculo) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.dataEntrada = dataEntrada;
        this.valor = valor;
        this.veiculo = veiculo;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="locacao_seq")
    @SequenceGenerator(name="locacao_seq")
    private Long id;

    @Column(name = "NOME_CLIENTE",nullable = false)
    private String nomeCliente;

    @Column(name = "CPF",nullable = false, length = 11)
    private String cpf;

    @Column(name = "DATA_ENTRADA", nullable = false)
    private LocalDateTime dataEntrada;

    @Column(name = "DATA_SAIDA")
    private LocalDateTime dataSaida;

    @Column(name = "VALOR",nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "VEICULO_ID",nullable = false)
    private Veiculo veiculo;
}
