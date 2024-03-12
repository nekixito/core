package edu.tienda.core.controllers;

import edu.tienda.core.configurations.ConfigurationParameters;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    @Autowired
    @Lazy
    private ProductoService productosService;

    @Autowired
    private ConfigurationParameters configurationParameters;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        System.out.println("params: " + configurationParameters.toString());

        List<Producto> productos = productosService.getProductos();

        return ResponseEntity.ok(productos);
    }
}
