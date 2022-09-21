package com.carraqueta.carraqueta.entity;

import com.carraqueta.carraqueta.enumeration.EnumMarca;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
@Data
public class Veiculo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="veiculo_seq")
    @SequenceGenerator(name="veiculo_seq")
    private Long id;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @Column(name = "MARCA", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumMarca marca;

    @Column(name = "PLACA",nullable = false, unique = true, length = 7)
    private String placa;

    @Column(name = "ANO",nullable = false, unique = true, length = 7)
    private Integer ano;

}
