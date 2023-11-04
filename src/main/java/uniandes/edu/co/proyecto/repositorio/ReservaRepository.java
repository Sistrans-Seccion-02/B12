package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    @Query (value = "SELECT * FROM Reservas", nativeQuery = true)
    Collection<Reserva> darReservas();


    @Query (value = "SELECT * FROM Reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO Reservas (id, fecha_entrada, fecha_salida, personas, check_in, check_out, paz_salvo) VALUES (?,?,?)", nativeQuery = true)
    void insertarReserva(@Param("fecha_entrada") String fecha_entrada, @Param("fecha_salida")String fecha_salida, @Param("personas") String personas, @Param("check_in") String check_in, @Param("check_out") String check_out, @Param("paz_salvo") boolean paz_salvo);

    @Modifying
    @Transactional
    @Query (value = "UPDATE Reservas SET fecha_entrada = :fecha_entrada, fecha_salida = :fecha_salida, personas = :personas, check_in =: check_in, check_out =: check_out, paz_salvo =: paz_salvo WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") int id, @Param("fecha_entrada") String Reserva, @Param("fecha_salida")String fecha_salida, @Param("personas") String personas,@Param("check_in") String check_in, @Param("check_out") String check_out, @Param("paz_salvo") boolean paz_salvo);

    @Modifying
    @Transactional
    @Query (value = "DELETE FROM Reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
    
}