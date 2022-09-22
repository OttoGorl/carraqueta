package com.carraqueta.carraqueta.entity;

import com.carraqueta.carraqueta.enumeration.EnumMarca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
public class Veiculo {

    public Veiculo(String modelo, EnumMarca marca, String placa, Integer ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
    }

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

    @Column(name = "ANO",nullable = false, length = 7)
    private Integer ano;

}
