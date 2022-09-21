package com.carraqueta.carraqueta.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumMarca {
    FORD("Ford"),
    TOYOTA("Toyota"),
    RENAULT("Renault");

    private final String descricao;
}
