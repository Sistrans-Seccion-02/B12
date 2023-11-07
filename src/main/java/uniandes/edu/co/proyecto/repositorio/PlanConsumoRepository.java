package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, String>{

    @Query(value = "SELECT * FROM planesconsumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();

    @Query(value = "SELECT * FROM planesconsumo WHERE nombre=:nombre", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planesconsumo (nombre, descripcion) VALUES ( :nombre, :descripcion)", nativeQuery = true)
    void insertarPlanConsumo(@Param("nombre") String nombre, @Param("descripcion") String descripcion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE planesconsumo SET descripcion = :descripcion WHERE nombre=:nombre", nativeQuery = true)
    void actualizarPlanConsumo(@Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesconsumo WHERE nombre=:nombre", nativeQuery = true)
    void eliminarPlanConsumo(@Param("nombre") String nombre);

}
