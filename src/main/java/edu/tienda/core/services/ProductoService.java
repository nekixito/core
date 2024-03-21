package edu.tienda.core.services;


import edu.tienda.core.domain.Producto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public ResponseEntity<?> modificar(Producto producto);

    public ResponseEntity deleteProducto(Integer id);
}
