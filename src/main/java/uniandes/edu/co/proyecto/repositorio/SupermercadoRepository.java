/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Supermercado;

import java.util.*;


public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer>{

    @Query(value = "SELECT * FROM supermercados", nativeQuery = true)
    Collection<Supermercado> darSupermercados();

    @Query(value = "SELECT * FROM supermercados WHERE id_servicio = :id_servicio", nativeQuery = true)
    Supermercado darSupermercado(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM supermercados WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarSupermercado(@Param("id_servicio") int id_servicio);
    
}

*/
