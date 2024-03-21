package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;
import edu.tienda.core.presistance.entities.ProductoEntity;
import edu.tienda.core.presistance.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("BD")
@ConditionalOnProperty(
        value="productos.estrategia",
        havingValue = "EN_BD")
public class ProductoServiceBDImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos(){

        //Forma más elegante con stream y lambdas
        List<Producto> productos = productoRepository.findAll().
                stream().map(productoEntity -> {
                    Producto producto = new Producto();
                    producto.setId(productoEntity.getId());
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setStock(productoEntity.getStock());

                    return producto;
                }).collect(Collectors.toList());


        /*
        List<ProductoEntity> productosEntities = productoRepository.findAll();

        List<Producto> productos = new ArrayList<>();

        for (ProductoEntity productoEntity: productosEntities){
            Producto producto = new Producto();

            producto.setId(productoEntity.getId());
            producto.setNombre(productoEntity.getNombre());
            producto.setPrecio(productoEntity.getPrecio());
            producto.setStock(productoEntity.getStock());

            productos.add(producto);

        }
        */


        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {
        //Mapeo de Producto a ProductoEntity
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setStock(producto.getStock());

        //Persistencia
        productoRepository.save(productoEntity);
    }

    @Override
    public ResponseEntity<?> modificar(Producto producto) {

        Optional<ProductoEntity> productoBuscado = productoRepository.findById(producto.getId());
        Producto productoActualizado = new Producto();

        System.out.println(productoBuscado);
        if(productoBuscado.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            productoBuscado.get().setNombre(producto.getNombre());
            productoBuscado.get().setPrecio(producto.getPrecio());
            productoBuscado.get().setStock(producto.getStock());

            ProductoEntity productoActualizadoEntity = productoRepository.save(productoBuscado.get());
            productoActualizado.setId(productoActualizadoEntity.getId());
            productoActualizado.setNombre(productoActualizadoEntity.getNombre());
            productoActualizado.setPrecio(productoActualizadoEntity.getPrecio());
            productoActualizado.setStock(productoActualizadoEntity.getStock());


            return ResponseEntity.ok(productoActualizado);

        }

    }

}
