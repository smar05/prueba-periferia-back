package com.example.periferiaback.enums;

public enum TipoDocumentoEnum {
    // Cedula de ciudadania
    C("C"),
    // Pasaporte
    P("P");

    private final String codigo;

    TipoDocumentoEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
