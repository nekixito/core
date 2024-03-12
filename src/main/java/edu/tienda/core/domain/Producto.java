package edu.tienda.core.domain;

import lombok.*;

@Data //Equivalente a poner las otras anotaciones
//@Getter
//@Setter
@NoArgsConstructor
//@EqualsAndHashCode
@AllArgsConstructor
//@ToString
public class Producto {

    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;

}
