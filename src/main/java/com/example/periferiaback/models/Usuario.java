package com.example.periferiaback.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.periferiaback.enums.TipoDocumentoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudad;
    @NotNull
    @Pattern(regexp = "^[CP]$", message = "El tipo de documento debe ser 'C' o 'P'")
    private TipoDocumentoEnum tipoDocumento;
    @NotNull
    @Size(min = 8, max = 11, message = "El número de documento debe tener entre 8 y 11 caracteres.")
    private Long numeroDocumento;

}
