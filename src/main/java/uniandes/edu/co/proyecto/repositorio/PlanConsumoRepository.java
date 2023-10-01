package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer>{

    @Query (value = "SELECT * FROM planesConsumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();


    @Query (value = "SELECT * FROM planesConsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO planesConsumo (id, nombre, noches, costo) VALUES (?,?,?)", nativeQuery = true)
    void insertarPlanConsumo(@Param("nombre") String nombre, @Param("noches")int noches, @Param("costo") float costo);

    @Modifying
    @Transactional
    @Query (value = "UPDATE planesConsumo SET nombre = :nombre, noches = :noches, costo = :costo WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") int id, @Param("nombre") String PlanConsumo, @Param("correo")int noches, @Param("costo") float costo);

    @Modifying
    @Transactional
    @Query (value = "DELETE FROM planesConsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id") int id);
    
}