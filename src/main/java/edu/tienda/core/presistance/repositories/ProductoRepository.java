package edu.tienda.core.presistance.repositories;

import edu.tienda.core.presistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {
}
