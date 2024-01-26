package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {

    @GetMapping("/hola")
    public String saludo(){
        System.out.println("Ejecutando el metodo saludo");
        return "Hola Mundo Spring Boot";
    }
}
