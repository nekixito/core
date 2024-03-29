package edu.tienda.core.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tienda.core.domain.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Primary //Qualifier tiene prioridad sobre Primary
@Service("JSON")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_JSON")
public class ProductoServiceJSONImpl implements ProductoService{

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos;

        try {
            productos = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/productos.json"),
                            new TypeReference<List<Producto>>() {});

                return productos;

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveProducto(Producto producto) {

    }

    @Override
    public ResponseEntity<?> modificar(Producto producto) {
        return null;
    }

    @Override
    public ResponseEntity deleteProducto(Integer id) {
        return null;
    }
}
