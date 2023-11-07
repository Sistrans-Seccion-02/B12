/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Tienda;

import java.util.*;


public interface TiendaRepository extends JpaRepository<Tienda, Integer>{

    @Query(value = "SELECT * FROM tiendas", nativeQuery = true)
    Collection<Tienda> darTiendas();

    @Query(value = "SELECT * FROM tiendas WHERE id_servicio = :id_servicio", nativeQuery = true)
    Tienda darTienda(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiendas WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarTienda(@Param("id_servicio") int id_servicio);
    
}

*/