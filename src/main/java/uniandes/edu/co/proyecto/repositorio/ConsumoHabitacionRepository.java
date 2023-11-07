package uniandes.edu.co.proyecto.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.ConsumoHabitacion;

public interface ConsumoHabitacionRepository extends JpaRepository<ConsumoHabitacion, Integer> {
    
    @Query(value = "SELECT h.numero as numeroHabitacion, co.costo FROM Consumos co, Habitaciones h, Servicios s WHERE co.habitaciones_numero = h.numero AND co.servicios_id_servicio = s.id_servicio", nativeQuery = true)
    Collection<ConsumoHabitacion> obtenerConsumosServicios();


}
