package edu.tienda.core.presistance.repositories;

import edu.tienda.core.presistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {

    List<ProductoEntity> findByPrecioLessThan(Double precio);

    List<ProductoEntity> findByNombreLike(String nombre);

    List<ProductoEntity> findByPrecioGreaterThanAndStockLessThan(Double precio,Integer stock);
}
