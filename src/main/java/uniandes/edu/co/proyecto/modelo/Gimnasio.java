package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")

public class Gimnasio extends Servicio {
    
    public Gimnasio(String nombre, Integer capacidad, Integer profundidad) {
        super(nombre, capacidad);
    }
    
}